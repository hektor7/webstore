package com.packt.webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;

/**
 * Product controller
 * 
 * @author hector
 *
 */
@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		// binder.setDisallowedFields("unitsInOrder", "discontinued");
		binder.setAllowedFields("productId", "name", "unitPrice",
				"description", "manufacturer", "category", "unitsInStock",
				"condition", "productImage");
	}

	/*
	 * Example of date converter
	 * 
	 * @InitBinder public void initialiseBinder (WebDataBinder binder) {
	 * DateFormat dateFormat = new SimpleDateFormat("MMM d, YYYY");
	 * CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat,
	 * true); binder.registerCustomEditor(Date.class, orderDateEditor); }
	 */

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());

		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model,
			@PathVariable("category") String productCategory) {

		model.addAttribute("products",
				productService.getProductsByCategory(productCategory));

		return "products";
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(
			@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {

		model.addAttribute("products",
				productService.getProductsByFilter(filterParams));

		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId,
			Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping("/{category}/{price}")
	public String filterProducts(@PathVariable("category") String category,
			@MatrixVariable(pathVar = "price") Map<String, List<String>> price,
			@RequestParam("manufacturer") String manufacturer, Model model) {

		// FIXME: Refactor: Altough this is the book's method, I think isn't a
		// good way
		List<Product> products = this.productService
				.getProductsByCategory(category);
		products.retainAll(this.productService.getProductsBypriceFilter(price));
		products.retainAll(this.productService
				.getProductsByManufacturer(manufacturer));

		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(
			@ModelAttribute("newProduct") Product newProduct) {
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(
			@ModelAttribute("newProduct") Product newProduct,
			BindingResult result, // For customize the WebDataBinder
			HttpServletRequest request) {

		this.saveProductImage(newProduct, request);

		this.productService.addProduct(newProduct);

		this.checkForNonAllowedFieldsOnInsert(result);

		return "redirect:/products";
	}

	/**
	 * Method to save the product image as multipart file from the form.
	 * 
	 * @param newProduct
	 *            from the form
	 * @param request
	 *            request.
	 */
	private void saveProductImage(Product newProduct, HttpServletRequest request) {
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				//TODO: Refactor this
				productImage.transferTo(new File(rootDirectory + File.separator
						+ "resources" + File.separator + "images"
						+ File.separator + newProduct.getProductId() + ".png"));

			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
	}

	/**
	 * Check for non allowed fields on insert.
	 * 
	 * @param result
	 *            Binding result
	 */
	private void checkForNonAllowedFieldsOnInsert(BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
	}

}
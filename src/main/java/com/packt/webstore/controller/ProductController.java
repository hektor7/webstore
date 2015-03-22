package com.packt.webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
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
				"condition", "productImage", "productUserManual", "language");
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

		List<Product> products = productService
				.getProductsByCategory(productCategory);

		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}

		model.addAttribute("products", products);

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
		// The service's method throws a non-checked exception that will be
		// handled by the handleError method.
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
			@ModelAttribute("newProduct") @Valid Product newProduct,
			BindingResult result, // For customize the WebDataBinder
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "addProduct";
		}

		this.saveProductImage(newProduct, request);

		this.saveUserManualPdf(newProduct, request);

		this.checkForNonAllowedFieldsOnInsert(result);

		this.productService.addProduct(newProduct);

		return "redirect:/products";
	}

	/**
	 * Method to save the product user's manual as multipart file.
	 * 
	 * @param newProduct
	 *            from the form
	 * @param request
	 *            request
	 */
	private void saveUserManualPdf(Product newProduct,
			HttpServletRequest request) {
		MultipartFile productUserManual = newProduct.getProductUserManual();

		if (productUserManual != null && !productUserManual.isEmpty()) {
			try {
				productUserManual.transferTo(new File(this
						.buildProductFilePath(newProduct, request,
								Product.PDF_MANUAL)));

			} catch (Exception e) {
				throw new RuntimeException(
						"Product user's manual saving failed", e);
			}
		}

	}

	/**
	 * This method creates a path for read or write resources. TODO: Move this
	 * method to a file service.
	 * 
	 * @param newProduct
	 *            Product
	 * @param request
	 *            Request
	 * @param fileType
	 *            Filetype of the file
	 * @return string with the path
	 */
	private String buildProductFilePath(Product newProduct,
			HttpServletRequest request, String fileType) {

		StringBuilder path = new StringBuilder();
		path.append(request.getSession().getServletContext().getRealPath("/"));
		path.append(File.separator);
		path.append("resources");
		path.append(File.separator);
		path.append(fileType);
		path.append(File.separator);
		path.append(newProduct.getProductId());
		path.append(this.fileTypeToExtension(fileType));

		return path.toString();
	}

	/**
	 * Returns a extension for a file type. TODO: Move this method to a file
	 * service.
	 * 
	 * @param fileType
	 *            file type
	 * @return string with extension
	 */

	private String fileTypeToExtension(String fileType) {
		String extension = "";
		if (Product.PDF_MANUAL.equals(fileType)) {
			extension = ".pdf";
		} else if (Product.IMAGE.equals(fileType)) {
			extension = ".png";
		}
		return extension;
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

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(this.buildProductFilePath(
						newProduct, request, Product.IMAGE)));

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

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req,
			ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}

	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
		return "invalidPromoCode";
	}

}
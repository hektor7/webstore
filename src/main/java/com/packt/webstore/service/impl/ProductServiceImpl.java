package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return this.productRepository.getAllProducts();
	}

	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(
			Map<String, List<String>> filterParams) {
		return this.productRepository.getProductsByFilter(filterParams);
	}

	public Product getProductById(String productId) {
		return this.productRepository.getProductById(productId);
	}

	public List<Product> getProductsByManufacturer(String manufacturer) {
		return this.productRepository.getProductsByManufacturer(manufacturer);
	}

	public List<Product> getProductsBypriceFilter(
			Map<String, List<String>> filterPrice) {
		return this.productRepository.getProductsByPriceRange(filterPrice);
	}

	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

}

package com.budiluhur.product_catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.budiluhur.product_catalog.model.Product;
import com.budiluhur.product_catalog.service.ProductService;

@SpringBootApplication
public class ProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(
			ProductService productService) {
		return args -> {
			System.out.println("=== SPRING BOOT PRODUCT CATALOG IS RUNNING ===");
			productService.createProduct(
					new Product("PRD-03",
							"Monitor Gaming 24 Inch",
							2100000.0));
			System.out.println("Daftar Produk di Spring Container:");
			productService.getAllProducts()
					.forEach(System.out::println);
		};
	}

}

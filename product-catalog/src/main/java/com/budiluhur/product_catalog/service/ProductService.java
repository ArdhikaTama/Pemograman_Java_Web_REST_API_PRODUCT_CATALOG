package com.budiluhur.product_catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.budiluhur.product_catalog.exception.ProductNotFoundException;
import com.budiluhur.product_catalog.model.Product;
import com.budiluhur.product_catalog.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. Mengambil semua produk
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Mengambil produk berdasarkan ID
    public Product getProductById(String id)
            throws ProductNotFoundException {
        return productRepository.findById(id);
    }

    // 3. Mencari produk berdasarkan nama
    public List<Product> searchProductsByName(String keyword) {
        return productRepository.searchByName(keyword);
    }

    // 4. Menambahkan produk baru
    public Product createProduct(Product product) {
        productRepository.addProduct(product);
        return product;
    }

    // 5. Memperbarui produk berdasarkan ID
    public Product updateProduct(String id, Product product)
            throws ProductNotFoundException {
        return productRepository.updateProduct(id, product);
    }

    // 6. Menghapus produk berdasarkan ID
    public boolean deleteProduct(String id)
            throws ProductNotFoundException {
        return productRepository.deleteById(id);
    }
}

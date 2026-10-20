
package com.budiluhur.product_catalog.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.budiluhur.product_catalog.exception.ProductNotFoundException;
import com.budiluhur.product_catalog.model.Product;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        // Data awal in-memory
        productList.add(new Product(
                "PRD-01",
                "Keyboard Mechanical",
                450000.0
        ));

        productList.add(new Product(
                "PRD-02",
                "Mouse Wireless Silent",
                175000.0
        ));
    }

    // Menambahkan produk
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Mengambil semua produk
    public List<Product> findAll() {
        return productList;
    }

    // Mencari produk berdasarkan ID
    public Product findById(String id)
            throws ProductNotFoundException {

        for (Product product : productList) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }

        throw new ProductNotFoundException(
                "Produk dengan ID '" + id + "' tidak ditemukan!"
        );
    }

    // Mencari produk berdasarkan nama (tidak membedakan huruf besar/kecil)
    public List<Product> searchByName(String keyword) {
        return productList.stream()
                .filter(product -> product.getName()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Memperbarui produk berdasarkan ID
    public Product updateProduct(
            String id,
            Product updatedProduct
    ) throws ProductNotFoundException {

        Product existingProduct = findById(id);

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());

        return existingProduct;
    }

    // Menghapus produk berdasarkan ID
    public boolean deleteById(String id)
            throws ProductNotFoundException {

        Product existingProduct = findById(id);

        return productList.remove(existingProduct);
    }
}

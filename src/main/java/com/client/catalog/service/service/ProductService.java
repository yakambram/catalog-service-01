package com.client.catalog.service.service;

import com.client.catalog.service.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(String id);
    List<Product> getAllProducts();
    Product save(Product product);
    List<Product> searchProducts(String query);
    Product createProduct(Product product);
}

package org.dependencytrack.service;

import org.dependencytrack.model.Product;
import org.dependencytrack.persistence.ProductQueryManager;

import java.util.List;

public class ProductService {

    private final ProductQueryManager queryManager = new ProductQueryManager();

    public Product createProduct(String name, String cpeCode) {
        return queryManager.createProduct(name, cpeCode);
    }

    public Product getProductById(Long id) {
        return queryManager.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return queryManager.getAllProducts();
    }

    public Product updateProduct(Product product) {
        return queryManager.updateProduct(product);
    }

    public void deleteProductById(Long id) {
        queryManager.deleteProductById(id);
    }
}

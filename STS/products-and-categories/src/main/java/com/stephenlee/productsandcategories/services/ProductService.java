package com.stephenlee.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.productsandcategories.models.Category;
import com.stephenlee.productsandcategories.models.Product;
import com.stephenlee.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    // returns all the products
    public List<Product> allProducts() {
        return productRepo.findAll();
    }
    // creates a product
    public Product createProduct(Product e) {
        return productRepo.save(e);
    }
    // retrieves a product
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
    public List<Product> allProductsWithCategory(Category category) {
    	return productRepo.findAllByCategories(category);
    }
    
    public List<Product> allProductsWithoutCategory(Category category) {
    	return productRepo.findByCategoriesNotContains(category);
    }
    
    public Product saveProduct(Product product) {
    	return productRepo.save(product);
    }
  
}


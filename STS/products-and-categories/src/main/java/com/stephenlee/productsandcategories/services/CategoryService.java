package com.stephenlee.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.productsandcategories.models.Category;
import com.stephenlee.productsandcategories.models.Product;
import com.stephenlee.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    // returns all the categories
    public List<Category> allCategories() {
        return categoryRepo.findAll();
    }
    // creates a category
    public Category createCategory(Category e) {
        return categoryRepo.save(e);
    }
    // retrieves a category
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
    public List<Category> allCategoriesWithProduct(Product product) {
    	return categoryRepo.findAllByProducts(product);
    }
    
    public List<Category> allCategoriesWithoutProduct(Product product) {
    	return categoryRepo.findByProductsNotContains(product);
    }
    
    public Category saveCategory(Category category) {
    	return categoryRepo.save(category);
    }
}


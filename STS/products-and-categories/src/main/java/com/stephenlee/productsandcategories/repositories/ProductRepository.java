package com.stephenlee.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.productsandcategories.models.Category;
import com.stephenlee.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    // this method retrieves all the books from the database
    List<Product> findAll();
    
    List<Product> findAllByCategories(Category category);
    
    List<Product> findByCategoriesNotContains(Category category);
}
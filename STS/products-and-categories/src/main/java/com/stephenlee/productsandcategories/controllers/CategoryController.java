package com.stephenlee.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stephenlee.productsandcategories.models.Category;
import com.stephenlee.productsandcategories.models.Product;
import com.stephenlee.productsandcategories.services.CategoryService;
import com.stephenlee.productsandcategories.services.ProductService;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/categories/new")
    public String categories(@ModelAttribute("category") Category category) {
        return "newCategory.jsp";
    }
    
    @PostMapping("/categories/new")
    public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "newCategory.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/categories/new";
        }
    }
    
    @GetMapping("/categories/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findCategory(id);
        if (category == null) {
    		return "redirect:/categories/new";
    	}
        List<Product> containProducts = productService.allProductsWithCategory(category);
        List<Product> notContainProducts = productService.allProductsWithoutCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("containProducts", containProducts);
        model.addAttribute("notContainProducts", notContainProducts);
        return "showCategory.jsp";
    }
    
    @PostMapping("/categories/{id}/addProduct")
    public String categoryAddProduct(@PathVariable("id") Long id, Model model, @RequestParam(value="addProduct", required=false) Long addProductId) {
    	if (addProductId == null) {
    		return "redirect:/categories/" + id.toString();
    	}
    	Category category = categoryService.findCategory(id);
    	if (category == null) {
    		return "redirect:/categories/new";
    	}
    	Product addProduct = productService.findProduct(addProductId);
    	if (addProduct == null) {
    		return "redirect:/categories/" + id.toString();
    	}
    	category.getProducts().add(addProduct);
    	categoryService.saveCategory(category);
    	
    	return "redirect:/categories/" + id.toString();
    	
    }
//    
//    @GetMapping("/categories/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Category category = categoryService.findCategory(id);
//        model.addAttribute("category", category);
//        return "edit.jsp";
//    }
//    
//    @PutMapping("/categories/edit/{id}")
//    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("category") Category category, BindingResult result) {
//        if (result.hasErrors()) {
//            return "edit.jsp";
//        } else {
//            categoryService.updateCategory(id, category);
//            return "redirect:/categories";
//        }
//    }
//    
//    @DeleteMapping("/categories/delete/{id}")
//    public String deleteCategory(@PathVariable("id") Long id) {
//        categoryService.deleteCategory(id);
//        return "redirect:/categories";
//    }
}


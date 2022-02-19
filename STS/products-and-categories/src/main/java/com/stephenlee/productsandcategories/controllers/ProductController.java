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
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/products/new")
    public String products(@ModelAttribute("product") Product product) {
        return "newProduct.jsp";
    }
    
    @PostMapping("/products/new")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "newProduct.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/products/new";
        }
    }
    
    @GetMapping("/products/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProduct(id);
        if (product == null) {
    		return "redirect:/products/new";
    	}
        List<Category> containCategories = categoryService.allCategoriesWithProduct(product);
        List<Category> notContainCategories = categoryService.allCategoriesWithoutProduct(product);
        model.addAttribute("product", product);
        model.addAttribute("containCategories", containCategories);
        model.addAttribute("notContainCategories", notContainCategories);
        return "showProduct.jsp";
    }
    
    @PostMapping("/products/{id}/addCategory")
    public String productAddCategory(@PathVariable("id") Long id, Model model, @RequestParam(value="addCategory", required=false) Long addCategoryId) {
    	if (addCategoryId == null) {
    		return "redirect:/products/" + id.toString();
    	}
    	Product product = productService.findProduct(id);
    	if (product == null) {
    		return "redirect:/products/new";
    	}
    	Category addCategory = categoryService.findCategory(addCategoryId);
    	if (addCategory == null) {
    		return "redirect:/products/" + id.toString();
    	}
        product.getCategories().add(addCategory);
        productService.saveProduct(product);
        
        return "redirect:/products/" + id.toString();
    }
//    
//    @GetMapping("/products/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Product product = productService.findProduct(id);
//        model.addAttribute("product", product);
//        return "edit.jsp";
//    }
      @GetMapping("/products/{id}/deleteAll")
      public String clearCategory(@PathVariable("id") Long id) {
    	  Product product = productService.findProduct(id);
    	  product.getCategories().clear();
    	  productService.saveProduct(product);
    	  return "redirect:/products/" + id.toString();
      }
//    
//    @PutMapping("/products/edit/{id}")
//    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("product") Product product, BindingResult result) {
//        if (result.hasErrors()) {
//            return "edit.jsp";
//        } else {
//            productService.updateProduct(id, product);
//            return "redirect:/products";
//        }
//    }
//    
//    @DeleteMapping("/products/delete/{id}")
//    public String deleteProduct(@PathVariable("id") Long id) {
//        productService.deleteProduct(id);
//        return "redirect:/products";
//    }
}


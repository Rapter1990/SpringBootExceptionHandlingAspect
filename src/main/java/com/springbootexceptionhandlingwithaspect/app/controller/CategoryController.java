package com.springbootexceptionhandlingwithaspect.app.controller;

import com.springbootexceptionhandlingwithaspect.app.model.Category;
import com.springbootexceptionhandlingwithaspect.app.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category/v1")
public class CategoryController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     *
     * {
     *     "name": "Category 1"
     * }
     */

    // http://localhost:8082/api/category/v1/categories
    @GetMapping("/categories")
    public List<Category> getAll() {
        LOG.info("CategoryController | getAll is called");
        return categoryService.getAll();
    }

    // http://localhost:8082/api/category/v1/category/add
    @PostMapping("/category/add")
    public Category createCategory(@RequestBody Category category) {
        LOG.info("CategoryController | createCategory is called");
        return categoryService.save(category);
    }

    // http://localhost:8082/api/category/v1/category/getCategoryById/{id}
    @GetMapping("/category/getCategoryById/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
        LOG.info("CategoryController | getCategoryById is called");
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    // http://localhost:8082/api/category/v1/category/update?id={id}
    @PutMapping("/category/update")
    public ResponseEntity<Category> updateCategory(@RequestParam long id, @RequestBody Category category) {
        LOG.info("CategoryController | updateCategory is called");
        Category updatedCategory = categoryService.update(id,category);
        return ResponseEntity.ok(updatedCategory);
    }

    // http://localhost:8082/api/category/v1/category/delete/{id}
    @DeleteMapping("/category/delete/{id}")
    public void deleteCategory(@PathVariable long id) {
        LOG.info("CategoryController | deleteCategory is called");
        categoryService.delete(id);
    }
}

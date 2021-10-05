package com.springbootexceptionhandlingwithaspect.app.service.impl;


import com.springbootexceptionhandlingwithaspect.app.model.Category;
import com.springbootexceptionhandlingwithaspect.app.request.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    public List<Category> getAll();
    public Category findById(Long id);
    public Category save(CategoryDTO categoryDTO);
    public void delete(Long id);
    public Category update(Long id, CategoryDTO categoryDTO);
    public void saveAll(List<Category> categoryList);
}

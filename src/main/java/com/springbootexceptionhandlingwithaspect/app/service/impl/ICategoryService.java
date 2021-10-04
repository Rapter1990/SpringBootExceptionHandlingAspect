package com.springbootexceptionhandlingwithaspect.app.service.impl;


import com.springbootexceptionhandlingwithaspect.app.model.Category;

import java.util.List;

public interface ICategoryService {

    public List<Category> getAll();
    public Category findById(Long id);
    public Category save(Category user);
    public void delete(Long id);
    public Category update(Long id, Category user);
}
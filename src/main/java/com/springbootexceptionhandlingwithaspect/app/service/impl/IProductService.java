package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getAll();
    public Product findById(Long id);
    public Product save(Product product);
    public void delete(Long id);
    public Product update(Long id, Product product);
    public void saveAll(List<Product> productList);
}

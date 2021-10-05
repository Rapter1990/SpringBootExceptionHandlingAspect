package com.springbootexceptionhandlingwithaspect.app.service.impl;

import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.model.Product;
import com.springbootexceptionhandlingwithaspect.app.request.ProductDTO;

import java.util.List;

public interface IProductService {

    public List<Product> getAll();
    public Product findById(Long id);
    public Product save(ProductDTO productDTO);
    public void delete(Long id);
    public Product update(Long id, ProductDTO productDTO);
    public void saveAll(List<Product> productList);
}

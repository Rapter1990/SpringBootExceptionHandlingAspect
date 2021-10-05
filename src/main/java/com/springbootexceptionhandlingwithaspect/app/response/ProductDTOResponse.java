package com.springbootexceptionhandlingwithaspect.app.response;

import com.springbootexceptionhandlingwithaspect.app.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTOResponse {

    private String name;
    private String description;
    private Double price;
    private List<Category> categories;
}

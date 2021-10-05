package com.springbootexceptionhandlingwithaspect.app.controller;

import com.springbootexceptionhandlingwithaspect.app.model.Product;
import com.springbootexceptionhandlingwithaspect.app.request.ProductDTO;
import com.springbootexceptionhandlingwithaspect.app.service.ProductService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
public class ProductController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final ProductService productService;


    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    // http://localhost:8082/api/product/v1/products
    @GetMapping("/products")
    public List<Product> getAll() {
        LOG.info("ProductController | getAll is called");
        return productService.getAll();
    }

    // http://localhost:8082/api/product/v1/product/add
    @PostMapping("/product/add")
    public Product createProduct(@RequestBody ProductDTO product) {
        LOG.info("ProductController | createProduct is called");
        return productService.save(product);
    }

    // http://localhost:8082/api/product/v1/product/getProductById/{id}
    @GetMapping("/product/getProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable long id) {
        LOG.info("ProductController | getProductById is called");

        ProductDTO productDTO = productService.findById(id);

        return ResponseEntity.ok(productDTO);
    }

    // http://localhost:8082/api/product/v1/product/update?id={id}
    @PutMapping("/product/update")
    public ResponseEntity<Product> updateProduct(@RequestParam long id, @RequestBody ProductDTO product) {
        LOG.info("ProductController | updateProduct is called");
        Product updatedProduct = productService.update(id,product);
        return ResponseEntity.ok(updatedProduct);
    }

    // http://localhost:8082/api/product/v1/product/delete/{id}
    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable long id) {
        LOG.info("ProductController | deleteProduct is called");
        productService.delete(id);
    }

}

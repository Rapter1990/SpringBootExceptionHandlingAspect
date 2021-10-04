package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.Category;
import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.model.Product;
import com.springbootexceptionhandlingwithaspect.app.repository.ProductRepository;
import com.springbootexceptionhandlingwithaspect.app.service.impl.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        LOG.info("ProductService | getAll is called");
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        LOG.info("ProductService | findById is called");

        LOG.info("ProductService | findById | category : " + productRepository.getById(id).toString());

        return productRepository.getById(id);
    }

    @Override
    public Product save(Product product) {
        LOG.info("ProductService | save is called");
        return productRepository.save(product);
    }

    @Override
    public void saveAll(List<Product> productList) {
        LOG.info("ProductService | saveAll is called");
        productRepository.saveAll(productList);
    }

    @Override
    public void delete(Long id) {
        LOG.info("ProductService | delete is called");
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            Product deletedProduct = product.get();
            productRepository.delete(deletedProduct);
            LOG.info("ProductService | delete | Category deleted ");
        }
    }

    @Override
    public Product update(Long id, Product product) {
        LOG.info("ProductService | update is called");
        Optional<Product> selectedProduct = productRepository.findById(id);
        if(selectedProduct.isPresent()) {
            Product productUpdate = selectedProduct.get();
            productUpdate.setId(id);
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setCategories(product.getCategories());
            productUpdate.setItems(product.getItems());

            return productRepository.save(productUpdate);
        }

        return null;
    }

}

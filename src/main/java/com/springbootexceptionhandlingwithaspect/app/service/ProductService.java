package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.model.Category;
import com.springbootexceptionhandlingwithaspect.app.model.Payment;
import com.springbootexceptionhandlingwithaspect.app.model.Product;
import com.springbootexceptionhandlingwithaspect.app.repository.CategoryRepository;
import com.springbootexceptionhandlingwithaspect.app.repository.ProductRepository;
import com.springbootexceptionhandlingwithaspect.app.request.ProductDTO;
import com.springbootexceptionhandlingwithaspect.app.service.impl.IProductService;
import org.modelmapper.ModelMapper;
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

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository, ModelMapper modelMapper) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    /**
     *
     * {
     *     "name": "Smart Phone",
     *     "description": "Smart Phone Description",
     *     "price": 1200.0,
     *     "categoryId": 1
     * }
     */


    @Override
    public List<Product> getAll() {
        LOG.info("ProductService | getAll is called");
        return productRepository.findAll();
    }

    @Override
    public ProductDTO findById(Long id) {
        LOG.info("ProductService | findById is called");

        LOG.info("ProductService | findById | category : " + productRepository.getById(id).toString());

        Product product = productRepository.getById(id);

        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        return productDTO;
    }

    @Override
    public Product save(ProductDTO productDTO) {
        LOG.info("ProductService | save is called");

        Category category = categoryRepository.getById(productDTO.getCategoryId());

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.getCategories().add(category);

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
    public Product update(Long id, ProductDTO productDTO) {
        LOG.info("ProductService | update is called");
        Optional<Product> selectedProduct = productRepository.findById(id);

        Category category = categoryRepository.getById(productDTO.getCategoryId());

        if(selectedProduct.isPresent()) {
            Product productUpdate = selectedProduct.get();
            productUpdate.setId(id);
            productUpdate.setName(productDTO.getName());
            productUpdate.setName(productDTO.getName());
            productUpdate.setPrice(productDTO.getPrice());
            productUpdate.setDescription(productDTO.getDescription());
            productUpdate.getCategories().add(category);

            return productRepository.save(productUpdate);
        }

        return null;
    }

}

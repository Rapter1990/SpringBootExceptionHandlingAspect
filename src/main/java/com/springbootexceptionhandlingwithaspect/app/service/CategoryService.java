package com.springbootexceptionhandlingwithaspect.app.service;

import com.springbootexceptionhandlingwithaspect.app.exception.CategoryNotFoundException;
import com.springbootexceptionhandlingwithaspect.app.model.Category;
import com.springbootexceptionhandlingwithaspect.app.model.User;
import com.springbootexceptionhandlingwithaspect.app.repository.CategoryRepository;
import com.springbootexceptionhandlingwithaspect.app.request.CategoryDTO;
import com.springbootexceptionhandlingwithaspect.app.service.impl.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAll() {
        LOG.info("CategoryService | getAll is called");
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        LOG.info("CategoryService | findById is called");

        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new CategoryNotFoundException("Category Not Found with id : " + id));

    }

    @Override
    public Category save(CategoryDTO categoryDTO) {
        LOG.info("CategoryService | save is called");

        Category category = new Category();
        category.setName(categoryDTO.getName());

        return categoryRepository.save(category);
    }

    @Override
    public void saveAll(List<Category> categoryList) {
        LOG.info("CategoryService | saveAll is called");
        categoryRepository.saveAll(categoryList);
    }

    @Override
    public void delete(Long id) {
        LOG.info("CategoryService | delete is called");
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            Category deletedCategory = category.get();
            categoryRepository.delete(deletedCategory);
            LOG.info("CategoryService | delete | Category deleted ");
        }else{
            throw new CategoryNotFoundException("Category Not Found with id : " + id);
        }
    }

    @Override
    public Category update(Long id, CategoryDTO categoryDTO) {
        LOG.info("CategoryService | update is called");
        Optional<Category> selectedCategory = categoryRepository.findById(id);
        if(selectedCategory.isPresent()) {
            Category categoryUpdate = selectedCategory.get();
            categoryUpdate.setId(id);
            categoryUpdate.setName(categoryDTO.getName());

            return categoryRepository.save(categoryUpdate);
        }else{
            throw new CategoryNotFoundException("Category Not Found with id : " + id);
        }

    }
}

package com.company.library.service;

import com.company.library.model.Category;
import com.company.library.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    protected Category getCategoryById(String id){
        return categoryRepository.findById(id).orElseThrow();
    }

}

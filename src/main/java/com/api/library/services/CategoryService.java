package com.api.library.services;

import com.api.library.models.Category;
import com.api.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getCategoryList(){
        return Streamable.of(this.categoryRepository.findAll()).toList();
    }
}

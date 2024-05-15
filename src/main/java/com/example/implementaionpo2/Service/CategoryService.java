package com.example.implementaionpo2.Service;

import com.example.implementaionpo2.Entity.Category;
import com.example.implementaionpo2.Entity.User;
import com.example.implementaionpo2.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public void addSampleCategories(){
        Category c1 = new Category();
        c1.setName("Warzywa");

        Category c2 = new Category();
        c2.setName("Owoce");

        Category c3 = new Category();
        c3.setName("Mieso");

        Category c4 = new Category();
        c4.setName("Nabial");

        Category c5 = new Category();
        c5.setName("Inne");

        categoryRepository.save(c1);
        categoryRepository.save(c2);
        categoryRepository.save(c3);
        categoryRepository.save(c4);
        categoryRepository.save(c5);
    }
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
}

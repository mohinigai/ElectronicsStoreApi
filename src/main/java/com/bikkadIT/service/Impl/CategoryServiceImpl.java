package com.bikkadIT.service.Impl;

import com.bikkadIT.Dtos.CategoryDto;
import com.bikkadIT.entity.Category;
import com.bikkadIT.repository.CategoryRepo;
import com.bikkadIT.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepo;
    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    private ModelMapper modelMapper;

    @Override
    public CategoryDto CreateCategory(CategoryDto catDto) {
        Category Catgoryies = this.modelMapper.map(catDto, Category.class);
        var save = categoryRepo.save(Catgoryies);
        return this.modelMapper.map(save, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto catDto, Integer CategoryId) {


        return null;
    }
}

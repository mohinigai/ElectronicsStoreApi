package com.bikkadIT.service;

import com.bikkadIT.Dtos.CategoryDto;

public interface CategoryService {

     CategoryDto CreateCategory (CategoryDto catDto);

     CategoryDto updateCategory (CategoryDto catDto, Integer CategoryId);

}

package com.hussein.services;

import com.hussein.dto.ArticleDto;
import com.hussein.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    void deleteById(Integer id);
}

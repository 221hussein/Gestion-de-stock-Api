package com.hussein.services;

import com.hussein.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

     ArticleDto save(ArticleDto dto);

     ArticleDto findById(Integer id);

     ArticleDto findByCodeArticle(String codeArticle);

     List<ArticleDto> findAll();

     void deleteById(Integer id);
}

package com.hussein.controller.api;

import com.hussein.dto.ArticleDto;
import com.hussein.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.hussein.utils.constants.APP_ROOT;

public interface CategoryApi {

    @PostMapping(value = APP_ROOT +"/category/create",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save (@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT +"/category/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById (@PathVariable("id")Integer id);

    @GetMapping(value = APP_ROOT+"/category/{code}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(String code);

    @GetMapping(value = APP_ROOT+"/category/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @GetMapping(APP_ROOT+"/category/{id}")
    void deleteById(@PathVariable("id") Integer id);
}

package com.hussein.services.impl;

import com.hussein.dto.CategoryDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.Category;
import com.hussein.repository.CategoryRepository;
import com.hussein.services.CategoryService;
import com.hussein.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Category not valid {}",dto);
            throw new InvalidEntityException("Category nest pas valide", ErrorCodes.CATEGORY_NOT_VALID);
        }
        Category savedCategory = categoryRepository.save(CategoryDto.toEntity(dto));
        return CategoryDto.fromEntity(savedCategory);
    }


    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("l'id de cette cetegory is null");
        }
        Optional<Category> category = categoryRepository.findById(id);
        CategoryDto dto = CategoryDto.fromEntity(category.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucun Category avec cette Id "+id+" n'est disponible dans la bas de donner " +ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Category code is null");
            throw new InvalidEntityException("Code category non valid ",ErrorCodes.ARTICLE_NOT_VALID);
        }
        Optional<Category> category = categoryRepository.findByCode(code);

        CategoryDto dto = CategoryDto.fromEntity(category.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucun code category n'est trouver",ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(
                CategoryDto ::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
        }
        categoryRepository.deleteById(id);
    }
}

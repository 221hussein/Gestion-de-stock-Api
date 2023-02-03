package com.hussein.repository;

import com.hussein.model.Article;
import com.hussein.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer > {

    Optional<Category> findByCode(String code);

}

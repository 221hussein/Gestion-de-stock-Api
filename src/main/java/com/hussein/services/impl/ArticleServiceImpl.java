package com.hussein.services.impl;

import com.hussein.dto.ArticleDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.Article;
import com.hussein.repository.ArticleRepository;
import com.hussein.services.ArticleService;
import com.hussein.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", dto);
            throw  new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID);
        }
        Article savedArticle = articleRepository.save(ArticleDto.toEntity(dto));
        return ArticleDto.fromEntity(savedArticle);
    }

    @Override
    public ArticleDto findById (Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);

        ArticleDto dto = ArticleDto.fromEntity(article.get());

         return Optional.of(dto).orElseThrow(() ->
            new EntityNotFoundException("Aucun article avec l'ID = "  +id +" na etais trouver dans la base de doner"
                    + ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article Code is null ");
             throw new InvalidEntityException("Code article non Valid",ErrorCodes.ARTICLE_NOT_VALID);
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);

        ArticleDto dto = ArticleDto.fromEntity(article.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucun article avec le code  = "  +codeArticle +" na etais trouver dans la base de donnee"
                        + ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Article Id is null");
        }
        articleRepository.deleteById(id);
    }
}

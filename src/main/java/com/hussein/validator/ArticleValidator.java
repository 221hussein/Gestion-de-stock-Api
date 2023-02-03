package com.hussein.validator;

import com.hussein.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le code d'article");
            errors.add("Veuillez renseigner la designation  d'article");
            errors.add("Veuillez renseigner le unitaire HT de l'article");
            errors.add("Veuillez renseigner le Taux TVA de l'article");
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
            errors.add("Veuillez selectionner une category pour l'article");

            return errors;

        }

        if (!StringUtils.hasLength(dto.getCodeArticle())) {
            errors.add("Veuillez renseigner le code d'article");
        }
        if (!StringUtils.hasLength(dto.getDesignation())) {
            errors.add("Veuillez renseigner la designation  d'article");
        }
        if (dto.getPrixUnitaireHt() == null) {
            errors.add("Veuillez renseigner le unitaire HT de l'article");
        }
        if (dto.getTauxTva() == null) {
            errors.add("Veuillez renseigner le Taux TVA de l'article");
        }
        if (dto.getPrixUnitaireTtc() == null) {
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
        }
        if (dto.getCategory() == null) {
            errors.add("Veuillez selectionner une category pour l'article");
        }

        return errors;
    }
}

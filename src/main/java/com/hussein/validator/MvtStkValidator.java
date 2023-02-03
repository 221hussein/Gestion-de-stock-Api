package com.hussein.validator;

import com.hussein.dto.MvtStkDto;

import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {

    public static List<String> validate(MvtStkDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseigner l'article du MvtStk");
            errors.add("veuiller renseigner la date du Mvt");
            errors.add("Veuillez renseigner la quantite du MvtStk");
            errors.add("veuillez renseigner le type du Mvt");

            return errors;
        }

        if (dto.getArticle() == null) {
            errors.add("veuillez renseigner l'article du MvtStk");
        }
        if (dto.getDateMvt() == null) {
            errors.add("veuiller renseigner la date du Mvt");
        }
        if (dto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantite du MvtStk");
        }
        if (dto.getTypeMvt() == null) {
            errors.add("veuillez renseigner le type du Mvt");
        }
        return errors;
    }
}

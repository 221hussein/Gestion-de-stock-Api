package com.hussein.validator;

import com.hussein.dto.LignedeCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LignedeCommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner larticle de la lignde commande");
            errors.add("Veuillez renseigner la commande fournisseur  de la ligne de commande");
            errors.add("Veuillez renseigner la quantite de la lignde commande");
            errors.add("Veuillez renseigner le prix unitaire de la lignde commande");

            return errors;
        }

        if (dto.getArticle() == null) {
            errors.add("Veuillez renseigner larticle de la lignde commande");
        }
        if (dto.getCommandeFournisseur() == null) {
            errors.add("Veuillez renseigner la commande fournisseur de la ligne de commande");
        }
        if (dto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantite de la lignde commande");
        }
        if (dto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la lignde commande");
        }

        return errors;
    }
}

package com.hussein.validator;

import com.hussein.dto.LignedeCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LignedeCommandeClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner larticle de la lignde commande");
            errors.add("Veuillez renseigner la commande client  de la ligne de commande");
            errors.add("Veuillez renseigner la quantite de la lignde commande");
            errors.add("Veuillez renseigner le prix unitaire de la lignde commande");

            return errors;
        }

        if (dto.getArticleDto() == null) {
            errors.add("Veuillez renseigner larticle de la lignde commande");
        }
        if (dto.getCommandeClientDto() == null) {
            errors.add("Veuillez renseigner la commande client de la ligne de commande");
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

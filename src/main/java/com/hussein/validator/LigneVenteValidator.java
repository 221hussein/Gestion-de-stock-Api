package com.hussein.validator;

import com.hussein.dto.LigneVenteDto;
import com.hussein.dto.LignedeCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

    public static List<String> validate(LigneVenteDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner la vente");
            errors.add("Veuillez renseigner la quantite de la ventes");
            errors.add("Veuillez renseigner le prix unitaire de la ventes ");

            return errors;
        }

        if (dto.getVentes() == null) {
            errors.add("Veuillez renseigner la vente");
        }
        if (dto.getQuantite() == null ) {
            errors.add("Veuillez renseigner la quantite de la ventes");
        }
        if (dto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la ventes ");
        }
        return errors;
    }
}

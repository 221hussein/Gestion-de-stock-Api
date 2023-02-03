package com.hussein.validator;

import com.hussein.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate (FournisseurDto dto) {
        List<String> error = new ArrayList<>();

        if (dto == null) {
            error.add("Veuillez renseigner le nom du fournisseur");
            error.add("Veuillez renseigner le prenom du fournisseur");
            error.add("Veuillez renseigner l'adresse  du fournisseur");
            error.add("Veuillez renseigner le mail du fournisseur");
            error.add("Veuillez renseigner le numero du fournisseur");

            return error;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            error.add("Veuillez renseigner le nom du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            error.add("Veuillez renseigner le prenom du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getMail())){
            error.add("Veuillez renseigner le mail du fournisseur");
        }
        if (dto.getAdresse() == null) {
            error.add("Veuillez renseigner l'adresse  du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getNumTel())){
            error.add("Veuillez renseigner le numero du fournisseur");
        }
        return error;
    }
}

package com.hussein.validator;

import com.hussein.dto.CategoryDto;
import com.hussein.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner l'email d'utilisateur");
            errors.add("Veuillez renseigner le nom de passe d'utilisateur");
            errors.add("Veuillez renseigner l'adresse dutilisateur");

            return errors;


        }

        if (!StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
            errors.add("Veuillez renseigner l'email d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getMoteDePasse())) {
            errors.add("Veuillez renseigner le nom de passe d'utilisateur");
        }
        if (utilisateurDto.getDateDeNaissance() == null) {
            errors.add("Veuillez renseigner la date de naissance de  l'utilisateur");
        }
        if (utilisateurDto.getAdresseDto() == null) {
            errors.add("Veuillez renseigner l'adresse dutilisateur");
        } else {
            if (!StringUtils.hasLength(utilisateurDto.getAdresseDto().getAdresse1())) {
                errors.add("le champs adress1 est obligatoir ");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresseDto().getCodePostale())) {
                errors.add("le champs le code postale est obligatoir");
            }            if (!StringUtils.hasLength(utilisateurDto.getAdresseDto().getAdresse1())) {
                errors.add("le champs ville est obligatoir ");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresseDto().getCodePostale())) {
                errors.add("le champs pays est obligatoir");
            }
        }

        return errors;
    }
}

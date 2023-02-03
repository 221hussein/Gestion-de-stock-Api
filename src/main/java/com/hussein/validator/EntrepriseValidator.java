package com.hussein.validator;

import com.hussein.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseigner le nom de l'entreprise");
            errors.add("veuillez renseigner la description de l'entreprise");
            errors.add("veuillez renseigner l'adresse de l'entreprise");
            errors.add("veuillez renseigner le codeFiscal de l'entreprise");
            errors.add("veuillez renseigner l'email de l'entreprise");
            errors.add("veuillez renseigner le numero  de telephone de l'entreprise");

            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getDescription())) {
            errors.add("veuillez renseigner la description de l'entreprise");
        }
        if (dto.getAdresse() == null) {
            errors.add("veuillez renseigner l'adresse de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getCodeFiscal())) {
            errors.add("veuillez renseigner le codeFiscal de l'entreprise");
        }
        return errors;

    }
}

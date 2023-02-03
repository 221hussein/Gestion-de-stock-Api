package com.hussein.validator;

import com.hussein.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {
    public static List<String> validate (VentesDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("veuiller renseigner le code de ventes ");
            errors.add("veuiller la date de ventes ");
            errors.add("veuiller le commentaire");

            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("veuiller renseigner le code de ventes ");
        }

        if (dto.getDateVente() == null) {
            errors.add("veuiller la date ventes ");
        }

        if (!StringUtils.hasLength(dto.getCommentaire())) {
            errors.add("veuiller renseigner le commentaire ");
        }
        return errors;
    }
}

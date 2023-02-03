package com.hussein.validator;

import com.hussein.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseignez le nom du client");
            errors.add("veuillez renseignez le prenom du client");
            errors.add("veuillez renseignez l'email du client");
            errors.add("veuillez renseignez le numero de telephone  du client");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("veuillez renseignez le nom du client");
        }

        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("veuillez renseignez le prenom du client");
        }

        if (!StringUtils.hasLength(dto.getMail())) {
            errors.add("veuillez renseignez l'email du client");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("veuillez renseignez le numero de telephone  du client");
        }
        return errors;
    }
}

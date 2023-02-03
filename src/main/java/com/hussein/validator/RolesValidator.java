package com.hussein.validator;

import com.hussein.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {
    public static List<String> Validate(RolesDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veuillez renseigner le rolename");
            errors.add("Veuillez renseigner lutilisateur");

            return errors;
        }
        if (!StringUtils.hasLength(dto.getRoleName())) {
            errors.add("veuillez renseigner le rolename");
        }
        if (dto.getUtilisateur() == null) {
            errors.add("veuillez renseigner le lutilisateur");
        }
        return errors;
    }
}

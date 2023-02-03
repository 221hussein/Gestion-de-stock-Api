package com.hussein.validator;

import com.hussein.dto.CommandeClientDto;
import com.hussein.dto.CommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    public static List<String> validate (CommandeFournisseurDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            return errors;
        }

        return errors;
    }
}

package com.hussein.validator;

import com.hussein.dto.CommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validate (CommandeClientDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            return errors;
        }

        return errors;
    }
}

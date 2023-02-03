package com.hussein.controller.api;

import com.hussein.dto.CommandeFournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hussein.utils.constants.APP_ROOT;

public interface CommandeFournisseurApi {

    @PostMapping(value = APP_ROOT+"/commandeFournisseur/create",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto save (@RequestBody CommandeFournisseurDto dto);

    @GetMapping(value = APP_ROOT+"/commandeFournisseu/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+"/commandeFournisseur/all",
    produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeFournisseurDto> findAll();

    @GetMapping(value = APP_ROOT+"/commandeFournisseur/{code}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findByCode(@PathVariable("code")String code);

    @DeleteMapping(APP_ROOT+"/commandeFournisseur/{id}")
    void deleteById(@PathVariable("id") Integer id);

}

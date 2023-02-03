package com.hussein.controller.api;

import com.hussein.dto.ClientDto;
import com.hussein.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.List;

import static com.hussein.utils.constants.APP_ROOT;

public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT+"/utilisateur/create",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save (UtilisateurDto dto);

    @GetMapping(value = APP_ROOT+"/utilisateur/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"/utilisateur/all",
    produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(APP_ROOT+"/utilisateur/{id}")
    void deleteById(@PathVariable("id") Integer id);
}

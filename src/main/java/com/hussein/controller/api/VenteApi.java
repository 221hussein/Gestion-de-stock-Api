package com.hussein.controller.api;

import com.hussein.dto.UtilisateurDto;
import com.hussein.dto.VentesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.hussein.utils.constants.APP_ROOT;

public interface VenteApi {
    @PostMapping(value = APP_ROOT+"/ventes/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
        VentesDto save (@RequestBody VentesDto dto);

    @GetMapping(value = APP_ROOT+"/ventes/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    VentesDto findById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"/vente/{code}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    VentesDto findByCode(@PathVariable("code") String code);

    @GetMapping(value = APP_ROOT+"/ventes/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<VentesDto> findAll();

    @DeleteMapping(APP_ROOT+"/ventes/{id}")
    void deleteById(@PathVariable("id") Integer id);

}

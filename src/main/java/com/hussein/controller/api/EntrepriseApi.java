package com.hussein.controller.api;

import com.hussein.dto.ArticleDto;
import com.hussein.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.hussein.utils.constants.APP_ROOT;

public interface EntrepriseApi {

    @PostMapping(value =APP_ROOT+ "/entreprise/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto dto);


    @GetMapping(value = APP_ROOT + "/entreprise/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"/entreprise/{code}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByCodeFiscal(@PathVariable("code") String codeFiscal);

    @GetMapping(value = APP_ROOT+"/entreprise/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @GetMapping(APP_ROOT+"/entreprise/{id}")
    void deleteById(@PathVariable("id") Integer id);
}

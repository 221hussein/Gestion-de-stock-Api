package com.hussein.controller.api;

import com.hussein.dto.ArticleDto;
import com.hussein.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.hussein.utils.constants.APP_ROOT;

public interface FournisseurApi {


    @PostMapping(value =APP_ROOT+ "/fournisseur/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto dto);


    @GetMapping(value = APP_ROOT + "/fournisseur/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("id") Integer id);

//    @GetMapping(value = APP_ROOT+"/fournisseur/{code}",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    FournisseurDto findByCodeArticle(String codeArticle);

    @GetMapping(value = APP_ROOT+"/fournisseur/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @GetMapping(APP_ROOT+"/fournisseur/{id}")
    void deleteById(@PathVariable("id") Integer id);
}

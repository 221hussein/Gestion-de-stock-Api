package com.hussein.controller.api;

import com.hussein.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.hussein.utils.constants.APP_ROOT;
@Api(APP_ROOT+"/article")
public interface ArticleApi {

    @PostMapping(value =APP_ROOT+ "/article/create",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
//this will allow us to documment our swagger
    @ApiOperation(value = "Enregistrer un article (Ajouter /modifier",
    notes = "cette methode permet denregistrer ou modifier un article",
    response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "L'object article cree ou modifier")
    })
    ArticleDto save(@RequestBody ArticleDto dto);


    @GetMapping(value = APP_ROOT + "/article/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)

    @ApiOperation(value = "rechercher un article par son Id",
            notes = "cette methode permet de rechercher un article par son id",
            response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "L'object article est bien trouver"),
            @ApiResponse(code = 404,message = "Aucun article existe dans la base de donner avec cette article")
    })
    ArticleDto findById(@PathVariable("id") Integer id);

    @GetMapping(value = APP_ROOT+"/article/{code}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="rechercher un article par son code",
        notes = "cette methode permet de touver le code dun article dans la base de donnee",
        response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "le code de larticle est bien trouver"),
            @ApiResponse(code = 404,message = "Aucun code existe dans la base de donner")
    })
    ArticleDto findByCodeArticle(@PathVariable("code") String codeArticle);


    @GetMapping(value = APP_ROOT+"/article/all",
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="revoie tous les articles",
            notes = "cette methode permet de revoyertous les article de la base de donner e",
            responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "les larticles sont bien trouver"),
    })
    List<ArticleDto> findAll();


    @ApiOperation(value ="permet de supprimer un article par son id",
            notes = "cette methode permet de supprimer un article par son id ",
            response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "suppression reussi "),
            @ApiResponse(code = 404,message = "id inexitant"),
    })
    @GetMapping(APP_ROOT+"/article/{id}")
    void deleteById(@PathVariable("id") Integer id);
}

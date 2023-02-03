package com.hussein.controller;

import com.hussein.controller.api.EntrepriseApi;
import com.hussein.dto.EntrepriseDto;
import com.hussein.services.EntrepriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EntrepriseController implements EntrepriseApi {

    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDto findByCodeFiscal(String codeFiscal) {
        return entrepriseService.findByCodeFiscal(codeFiscal);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        entrepriseService.deleteById(id);
    }
}

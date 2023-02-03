package com.hussein.controller;

import com.hussein.controller.api.FournisseurApi;
import com.hussein.dto.ArticleDto;
import com.hussein.dto.FournisseurDto;
import com.hussein.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    @Autowired
    private FournisseurService fournisseurService;

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        fournisseurService.deleteById(id);
    }
}

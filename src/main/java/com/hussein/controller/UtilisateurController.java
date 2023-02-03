package com.hussein.controller;

import com.hussein.controller.api.UtilisateurApi;
import com.hussein.dto.UtilisateurDto;
import com.hussein.services.UtilisateurService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UtilisateurController implements UtilisateurApi {


    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        utilisateurService.deleteById(id);
    }
}

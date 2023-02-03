package com.hussein.controller;

import com.hussein.controller.api.VenteApi;
import com.hussein.dto.VentesDto;
import com.hussein.repository.VentesRepository;
import com.hussein.services.VenteService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VenteController implements VenteApi {

    private final VenteService venteService;

    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        return venteService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return venteService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return venteService.findByCodeVentes(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        venteService.deleteById(id);
    }
}

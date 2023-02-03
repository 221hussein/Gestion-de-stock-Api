package com.hussein.services;

import com.hussein.dto.ArticleDto;
import com.hussein.dto.VentesDto;

import java.util.List;

public interface VenteService {

    VentesDto save(VentesDto dto);

    VentesDto findById(Integer id);

    VentesDto findByCodeVentes(String codeVentes);

    List<VentesDto> findAll();

    void deleteById(Integer id);
}

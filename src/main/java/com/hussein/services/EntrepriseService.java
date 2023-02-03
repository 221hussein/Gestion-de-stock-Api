package com.hussein.services;

import com.hussein.dto.ArticleDto;
import com.hussein.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findByCodeFiscal(String codeFiscal);

    List<EntrepriseDto> findAll();

    void deleteById(Integer id);
}

package com.hussein.services;

import com.hussein.dto.ClientDto;
import com.hussein.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    void deleteById(Integer id);
}

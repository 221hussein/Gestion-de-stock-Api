package com.hussein.services;

import com.hussein.dto.ClientDto;
import com.hussein.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void deleteById(Integer id);
}

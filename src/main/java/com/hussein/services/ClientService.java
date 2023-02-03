package com.hussein.services;

import com.hussein.dto.ArticleDto;
import com.hussein.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void deleteById(Integer id);

}

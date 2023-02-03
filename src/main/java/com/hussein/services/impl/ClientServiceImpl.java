package com.hussein.services.impl;

import com.hussein.dto.ArticleDto;
import com.hussein.dto.ClientDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.Client;
import com.hussein.repository.ClientRepository;
import com.hussein.services.ClientService;
import com.hussein.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not Valid {}" ,dto);
            throw new InvalidEntityException("le client n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID);
        }
        Client savedClient = clientRepository.save(ClientDto.toEntity(dto));
        return ClientDto.fromEntity(savedClient);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client Id is null");
            throw new InvalidEntityException("");
        }
        Optional<Client> client = clientRepository.findById(id);
        ClientDto dto = ClientDto.fromEntity(client.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucun Client avec l'id " +id +
                        "na etais trouver dans la base de donner ",
                        ErrorCodes.CLIENT__NOT_FOUND));
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Client id is null");
        }
        clientRepository.deleteById(id);
    }
}

package com.hussein.controller;

import com.hussein.controller.api.ClientApi;
import com.hussein.dto.ClientDto;
import com.hussein.services.ClientService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        clientService.deleteById(id);
    }

    public static class VenteController {
    }
}

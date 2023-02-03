package com.hussein.controller;

import com.hussein.controller.api.CommandeFournisseurApi;
import com.hussein.dto.CommandeFournisseurDto;
import com.hussein.services.CommandeFournisseurService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    private final CommandeFournisseurService commandeFournisseurService;

    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        return commandeFournisseurService.save(dto);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }

    @Override
    public void deleteById(Integer id) {
        commandeFournisseurService.deleteById(id);
    }
}

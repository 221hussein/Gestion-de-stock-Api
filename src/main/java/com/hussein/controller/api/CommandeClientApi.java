package com.hussein.controller.api;

import com.hussein.dto.ClientDto;
import com.hussein.dto.CommandeClientDto;
import com.hussein.dto.VentesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hussein.utils.constants.APP_ROOT;

public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT+"/commandeClient/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto save (@RequestBody CommandeClientDto dto);

    @GetMapping(value = APP_ROOT + "/commandeclient/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+"/commandeclient/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeClientDto> findAll();

    @GetMapping(value = APP_ROOT+"/commandeclient/{code}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findByCode(@PathVariable("code") String code);

    @DeleteMapping(APP_ROOT+"/commandeclient/{id}")
    void deleteById(@PathVariable("id") Integer id);
}

package com.hussein.controller.api;

import com.hussein.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hussein.utils.constants.APP_ROOT;

public interface ClientApi {

    @PostMapping(value = APP_ROOT+"/client/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save (@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT + "/client/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+"/client/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping(APP_ROOT+"/client/{id}")
    void deleteById(@PathVariable("id") Integer id);
}

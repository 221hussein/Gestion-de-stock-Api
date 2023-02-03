package com.hussein.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hussein.model.Client;
import com.hussein.model.CommandeClient;
import com.hussein.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {

    private  Integer id;

    private String code;

    private Instant dateCommande;

    private Integer idEntreprise;

    @JsonIgnore
    private ClientDto clientDto;


    private List<LignedeCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient ) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .build();
    }


    public static CommandeClient toEntity (CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClient.getId());
        commandeClient.setCode(commandeClient.getCode());
        commandeClient.setDateCommande(commandeClient.getDateCommande());

        return commandeClient;
    }

}

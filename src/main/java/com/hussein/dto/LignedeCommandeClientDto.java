package com.hussein.dto;

import com.hussein.model.Article;
import com.hussein.model.CommandeClient;
import com.hussein.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
@Data
@Builder
public class LignedeCommandeClientDto {

    private  Integer id;

    private ArticleDto articleDto;

    private CommandeClientDto commandeClientDto;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;


    public static LignedeCommandeClientDto fromEntity (LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }

        return LignedeCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeClient toEntity (LignedeCommandeClientDto lignedeCommandeClientDto) {
        if (lignedeCommandeClientDto == null) {
            return null;
        }
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(lignedeCommandeClientDto.getId());
        ligneCommandeClient.setQuantite(lignedeCommandeClientDto.getQuantite());
        ligneCommandeClient.setPrixUnitaire(lignedeCommandeClientDto.getPrixUnitaire());

        return ligneCommandeClient;

    }
}

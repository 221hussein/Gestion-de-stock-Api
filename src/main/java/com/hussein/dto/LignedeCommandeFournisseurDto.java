package com.hussein.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hussein.model.Article;
import com.hussein.model.CommandeFournisseur;
import com.hussein.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


@Builder
@Data
public class LignedeCommandeFournisseurDto {

    private  Integer id;

    private Integer idEntreprise;

    @JsonIgnore
    private ArticleDto article;

    @JsonIgnore
    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public static LignedeCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null) {
            return null;
        }
        return LignedeCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LignedeCommandeFournisseurDto lignedeCommandeFournisseurDto) {
        if (lignedeCommandeFournisseurDto == null) {
            return null;
        }
        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseur.getId());
        ligneCommandeFournisseur.setQuantite(lignedeCommandeFournisseurDto.getQuantite());
        ligneCommandeFournisseur.setPrixUnitaire(lignedeCommandeFournisseurDto.getPrixUnitaire());

        return ligneCommandeFournisseur;
    }

}

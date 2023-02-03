package com.hussein.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hussein.model.Adresse;
import com.hussein.model.Entreprise;
import com.hussein.model.Utilisateur;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@Data
@Builder
public class EntrepriseDto {

    private  Integer id;

    private String nom;

    private String description;

    private Integer idEntreprise;

    @JsonIgnore
    private Adresse adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String siteWeb;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto formEntity (Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .photo(entreprise.getPhoto())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }

    public static Entreprise toEntity (EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());

        return entreprise;
    }
}

package com.hussein.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hussein.model.Adresse;
import com.hussein.model.Entreprise;
import com.hussein.model.Roles;
import com.hussein.model.Utilisateur;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
public class UtilisateurDto {

    private  Integer id;

    private Integer idEntreprise;

    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    private String moteDePasse;

    @JsonIgnore
    private AdresseDto adresseDto;

    private String photo;

    @JsonIgnore
    private EntrepriseDto entreprise;

    @JsonIgnore
    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .idEntreprise(utilisateur.getEntreprise().getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .adresseDto(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .moteDePasse(utilisateur.getMoteDePasse())
                .photo(utilisateur.getPhoto())
                .entreprise(EntrepriseDto.formEntity(utilisateur.getEntreprise()))
                .roles(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
//        utilisateur.setIdEntreprise(utilisateur.getIdEntreprise());
        utilisateur.setNom(utilisateur.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresseDto()));
        utilisateur.setMoteDePasse(utilisateurDto.getMoteDePasse());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
        utilisateur.setRoles(utilisateurDto.getRoles() != null ?
                utilisateurDto.getRoles().stream()
                        .map(RolesDto::toEntity)
                        .collect(Collectors.toList()) : null);
        return utilisateur;
    }
}

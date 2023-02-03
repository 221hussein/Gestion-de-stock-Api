package com.hussein.dto;

import com.hussein.model.LigneVente;
import com.hussein.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Builder
@Data
public class VentesDto {

    private  Integer id;

    private Integer idEntreprise;

    private String code;

    private Instant dateVente;

    private String commentaire;

    private List<LigneVenteDto> ligneVentes;

    public static VentesDto fromEntity(Ventes ventes) {
        if (ventes == null) {
            return null;
        }

        return VentesDto.builder()
                .id(ventes.getId())
//                .idEntreprise(ventes.getIdEntreprise())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .build();
    }

    public static Ventes toEntity (VentesDto ventesDto) {
        if (ventesDto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setCode(ventesDto.getCode());
//        ventes.setIdEntreprise(ventesDto.getIdEntreprise());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setCommentaire(ventesDto.getCommentaire());

        return ventes;
    }
}

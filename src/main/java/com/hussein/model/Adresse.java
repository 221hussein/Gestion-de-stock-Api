package com.hussein.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse  {

    @Column(name = "addresse1")
    private String adresse1;

    @Column(name = "address2")
    private String adresse2;

    @Column(name = "ville")
    private String ville;

//    @Column(name = "identreprise")
//    private Integer idEntreprise;

    @Column(name = "codepostale")
    private String codePostale;

    @Column(name = "pays")
    private String pays;
}

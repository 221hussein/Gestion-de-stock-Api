package com.hussein.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventes")
public class Ventes extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "datevente")
    private Instant dateVente;

//    @Column(name = "identreprise")
//    private Integer idEntreprise;

    @Column(name = "commentaire")
    private String commentaire;

    @OneToMany(mappedBy = "ventes")
     private List<LigneVente> ligneVentes;
}

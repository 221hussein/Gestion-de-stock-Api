package com.hussein.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mvtStk")
public class MvtStk extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "datemvt")
    private Instant dateMvt;

//    @Column(name = "identreprise")
//    private Integer idEntreprise;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "typemvt")
    private TypeMvtStk typeMvt;

}

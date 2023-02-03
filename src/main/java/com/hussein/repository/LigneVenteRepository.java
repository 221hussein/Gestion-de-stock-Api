package com.hussein.repository;

import com.hussein.model.CommandeClient;
import com.hussein.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {
}

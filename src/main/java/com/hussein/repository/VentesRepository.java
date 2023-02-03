package com.hussein.repository;

import com.hussein.model.CommandeClient;
import com.hussein.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentesRepository extends JpaRepository<Ventes,Integer> {

    Optional<Ventes> findVentesByCode(String code);
}

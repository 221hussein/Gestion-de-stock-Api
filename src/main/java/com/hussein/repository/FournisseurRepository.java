package com.hussein.repository;

import com.hussein.model.CommandeClient;
import com.hussein.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
}

package com.hussein.repository;

import com.hussein.model.Article;
import com.hussein.model.CommandeClient;
import com.hussein.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {

    Optional<Entreprise> findEntrepriseByCodeFiscal (String codeArticle);

}

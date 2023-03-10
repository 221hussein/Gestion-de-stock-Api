package com.hussein.repository;

import com.hussein.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {

    Optional<CommandeClient> findCommandeClientByCode(String code);
}

package com.hussein.services.impl;

import com.hussein.dto.UtilisateurDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.Utilisateur;
import com.hussein.repository.UtilisateurRepository;
import com.hussein.services.UtilisateurService;
import com.hussein.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("utilisateur is not valid {}",dto);
            throw  new InvalidEntityException("L'article n'est pas valide", ErrorCodes.UTILISATEUR_NOT_FOUND);
        }
        Utilisateur savedUtilisateur = utilisateurRepository.save(UtilisateurDto.toEntity(dto));
        return UtilisateurDto.fromEntity(savedUtilisateur);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("Utilisateur id is null");
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        UtilisateurDto dto = UtilisateurDto.fromEntity(utilisateur.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucun utilisateur avec cette id "+id+" na pas etait trouver",ErrorCodes.UTILISATEUR_NOT_FOUND));
    }



    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Utilisateur Id is null");
        }
        utilisateurRepository.deleteById(id);
    }
}

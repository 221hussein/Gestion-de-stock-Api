package com.hussein.services.impl;

import com.hussein.dto.FournisseurDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.Fournisseur;
import com.hussein.repository.FournisseurRepository;
import com.hussein.services.FournisseurService;
import com.hussein.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Fournisseur id not Valid {}",dto);
            throw  new InvalidEntityException("Fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }
        Fournisseur savedFournisseur = fournisseurRepository.save(FournisseurDto.toEntity(dto));
        return FournisseurDto.fromEntity(savedFournisseur);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("Fournisseur Id is null");
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        FournisseurDto dto = FournisseurDto.fromEntity(fournisseur.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucun fournisseur avec l'id "+id+" nest trouver dans la DB",ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Fournisseur id is null");
        }
        fournisseurRepository.deleteById(id);
    }
}

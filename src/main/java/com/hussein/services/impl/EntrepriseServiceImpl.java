package com.hussein.services.impl;

import com.hussein.dto.EntrepriseDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.Entreprise;
import com.hussein.repository.EntrepriseRepository;
import com.hussein.services.EntrepriseService;
import com.hussein.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Entreprise not Valid");
            throw new InvalidEntityException("l'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID);
        }
        Entreprise entreprise = entrepriseRepository.save(EntrepriseDto.toEntity(dto));
        return EntrepriseDto.formEntity(entreprise);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Entreprise id is null");
            throw new InvalidEntityException("");
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        EntrepriseDto dto = EntrepriseDto.formEntity(entreprise.get());

        return Optional.of(dto).orElseThrow(()->
                new InvalidEntityException("Aucun Entreprise avec cet" +
                        " " +id +" na etais trouver dans la BD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findByCodeFiscal(String codeFiscal) {
        if (!StringUtils.hasLength(codeFiscal)) {
            log.error("Entreprise fiscalCode is null");
            throw new InvalidEntityException((""));
        }
        Optional<Entreprise> entreprise =
                entrepriseRepository.findEntrepriseByCodeFiscal(codeFiscal);

        EntrepriseDto dto = EntrepriseDto.formEntity(entreprise.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucun codeFiscal "+ codeFiscal+ "na etais trouver",ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::formEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Entreprise id is null");
        }
        entrepriseRepository.deleteById(id);
    }
}

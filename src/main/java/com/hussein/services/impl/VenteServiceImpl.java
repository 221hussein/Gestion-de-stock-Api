package com.hussein.services.impl;

import com.hussein.dto.LigneVenteDto;
import com.hussein.dto.VentesDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.Article;
import com.hussein.model.LigneVente;
import com.hussein.model.Ventes;
import com.hussein.repository.ArticleRepository;
import com.hussein.repository.LigneVenteRepository;
import com.hussein.repository.VentesRepository;
import com.hussein.services.VenteService;
import com.hussein.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {

    private final VentesRepository ventesRepository;
    private final ArticleRepository articleRepository;
    private final LigneVenteRepository ligneVenteRepository;

    public VenteServiceImpl(VentesRepository ventesRepository, ArticleRepository articleRepository, LigneVenteRepository ligneVenteRepository) {
        this.ventesRepository = ventesRepository;
        this.articleRepository = articleRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Vente is not Valid {} ",dto);
            throw new InvalidEntityException("la vente nest pas valide", ErrorCodes.VENTE_NOT_VALID);
        }

        List<String> articleErrors = new ArrayList<>();
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'id "+ligneVenteDto.getArticle().getId() +" n'est present dans la BD");
            }
        });
        if (!articleErrors.isEmpty()) {
            log.error("one or more article were foud in the DB, {}",errors);
            throw new InvalidEntityException("un ou plusieur article nont pas ete toube",ErrorCodes.VENTE_NOT_VALID);
        }
        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));
        dto.getLigneVentes().forEach(ligneVenteDto ->  {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVentes(savedVentes);
            ligneVenteRepository.save(ligneVente);
        });
        return VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Vente id is null");
        }
        Optional<Ventes> vente = ventesRepository.findById(id);
        VentesDto dto = VentesDto.fromEntity(vente.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("aucune ventes avec cette id na etais trouve dans la base de donner"
                ,ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto findByCodeVentes(String codeVentes) {
        if (!StringUtils.hasLength(codeVentes)) {
            log.error("Vente code is null");
            throw new InvalidEntityException("Conde vente  :"+codeVentes+" pas trouver dans la BD",
                    ErrorCodes.VENTE_NOT_FOUND);
        }
        return ventesRepository.findVentesByCode(codeVentes)
                .map(VentesDto ::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Vente client na pas ete wvec le code",
                        ErrorCodes.VENTE_NOT_VALID
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto ::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("vente is null");
        }
        ventesRepository.deleteById(id);
    }
}

package com.hussein.services.impl;

import com.hussein.dto.CommandeFournisseurDto;
import com.hussein.dto.LignedeCommandeClientDto;
import com.hussein.dto.LignedeCommandeFournisseurDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.*;
import com.hussein.repository.ArticleRepository;
import com.hussein.repository.CommandeFournisseurRepository;
import com.hussein.repository.FournisseurRepository;
import com.hussein.repository.LigneCommandeFournisseurRepository;
import com.hussein.services.CommandeFournisseurService;
import com.hussein.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;

    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;

    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository, FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valid");
            throw new InvalidEntityException("Commande fournisseur invalid", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if (fournisseur.isPresent()) {
            log.error("Fournisseur avec cette id {}" +dto.getFournisseur().getId() +" n'est pas trouver dans la base de donner");
            throw new EntityNotFoundException("Aucun fournisseur avec cette id "+dto.getFournisseur().getId()+"n'est trouver dans la  base de donner");
        }

        List<String> articleErrors = new ArrayList<>();
        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdFr -> {
                if (ligCmdFr.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdFr.getId());
                    if (article.isEmpty()) {
                        articleErrors.add("larticle avec cette id " +ligCmdFr.getArticle().getId() +"na pas ete trouve dans la base de donne");
                    }

                }else {
                    articleErrors.add("Impossible d'enregistrer une commande avec un article null");
                }
            });
        }
        if (articleErrors.isEmpty()) {
            log.warn(" {}",articleErrors);
            throw new InvalidEntityException("Article nexiste pas dans la base de donner",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }
         CommandeFournisseur savedCmdFr = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));
        //assigner la commmande au ligne de commande fournisseur
        dto.getLigneCommandeFournisseurs().forEach(
                ligCmdFr -> {
                    LigneCommandeFournisseur ligneCommandeFournisseur =
                            LignedeCommandeFournisseurDto.toEntity(ligCmdFr);
                    ligneCommandeFournisseur.setCommandeFournisseur(savedCmdFr);
                    ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
                });
        return null;

    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("Commande fournisseur id is null");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande fournisseur avec cette id"+
                                id,ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Code Commande fournisseur is null");
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune code na ete trouver pour cette commande"+code,
                        ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));

    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll()
                .stream().map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Commande fournisseur id is null");
        }
        commandeFournisseurRepository.deleteById(id);
    }
}

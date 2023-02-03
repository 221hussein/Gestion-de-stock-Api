package com.hussein.services.impl;

import com.hussein.dto.CommandeClientDto;
import com.hussein.dto.LignedeCommandeClientDto;
import com.hussein.exception.EntityNotFoundException;
import com.hussein.exception.ErrorCodes;
import com.hussein.exception.InvalidEntityException;
import com.hussein.model.Article;
import com.hussein.model.Client;
import com.hussein.model.CommandeClient;
import com.hussein.model.LigneCommandeClient;
import com.hussein.repository.ArticleRepository;
import com.hussein.repository.ClientRepository;
import com.hussein.repository.CommandeClientRepository;
import com.hussein.repository.LigneCommandeClientRepository;
import com.hussein.services.CommandeClientService;
import com.hussein.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImp implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;

    private final LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    public CommandeClientServiceImp(CommandeClientRepository commandeClientRepository, LigneCommandeClientRepository ligneCommandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
      List<String> errors = CommandeClientValidator.validate(dto);
      if (!errors.isEmpty()) {
          log.error("Command client n'est pas valid");
          throw new InvalidEntityException("commande client invalid", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);
      }

        Optional<Client> client = clientRepository.findById(dto.getId());
        if (client.isPresent()){
            log.warn("Client avec cette id {} " +dto.getClientDto().getId()+ "n'est pas trouver dans la base de donner" );
            throw new EntityNotFoundException("Aucun client avec cette id "+dto.getClientDto().getId() + "na ete trouver dans la base de donner ");
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                if (ligCmdClt.getArticleDto() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticleDto().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("l'article avec l'id"+ligCmdClt.getArticleDto().getId()+" nexiste pas");
                    }
                }else {
                    articleErrors.add("Impossible d'enregistrer une commande avec un article null");
                }
            });
        }
        if (articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article nexiste pas dans la base de donner",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }

        CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
//assigner la commmande au ligne de commande client
        dto.getLigneCommandeClients().forEach(
                ligCmdClt -> {
                    LigneCommandeClient ligneCommandeClient =
                            LignedeCommandeClientDto.toEntity(ligCmdClt);
                    ligneCommandeClient.setCommandeClient(savedCmdClt);
                    ligneCommandeClientRepository.save(ligneCommandeClient);
                });
        return CommandeClientDto.fromEntity(savedCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if (id == null) {
            log.error("Commande client id is null");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto:: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                "Aucune commande client n'a ete trouve avec l'id"+
                id,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Commade client Code is null");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto ::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune code na ete trouver pour cette Commande"+code,
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("Commande client ID is null");
            return;
        }
        commandeClientRepository.deleteById(id);
    }
}

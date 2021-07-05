package com.bootcamp.grupo4.linktracker.services;

import com.bootcamp.grupo4.linktracker.dtos.LinkFormDTO;
import com.bootcamp.grupo4.linktracker.entities.Link;
import com.bootcamp.grupo4.linktracker.repositories.LinkRepository;
import com.bootcamp.grupo4.linktracker.validations.exceptions.LinkNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link criarLink(LinkFormDTO formDTO) {
        return linkRepository.criar(formDTO.converter());
    }

    public Link findLink(Long linkId, String senha) {
        Link foundLink = this.linkRepository.findLinkById(linkId);

        if (foundLink != null && foundLink.isValido() && foundLink.getSenha().equals(senha)) {
            this.atualizarQuantidadeRedirects(foundLink);
            return foundLink;
        }
        throw new LinkNotFoundException();
    }

    private void atualizarQuantidadeRedirects(Link link) {
        link.setQuantidadeRedirects(link.getQuantidadeRedirects()+1);

        this.linkRepository.atualizarLink(link);
    }

    public Link obterMetricas(Long linkId) {
        Link foundLink = this.linkRepository.findLinkById(linkId);

        if (foundLink != null) {
            return foundLink;
        }
        throw new LinkNotFoundException();
    }

    public Link invalidarLink(Long linkId) {
        Link foundLink = this.linkRepository.findLinkById(linkId);

        if (foundLink != null) {
            foundLink.setValido(false);

            this.linkRepository.atualizarLink(foundLink);

            return foundLink;
        }
        throw new LinkNotFoundException();
    }
}

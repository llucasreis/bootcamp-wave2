package com.bootcamp.grupo4.linktracker.controllers;

import com.bootcamp.grupo4.linktracker.dtos.LinkDTO;
import com.bootcamp.grupo4.linktracker.dtos.LinkFormDTO;
import com.bootcamp.grupo4.linktracker.dtos.LinkMetricDTO;
import com.bootcamp.grupo4.linktracker.entities.Link;
import com.bootcamp.grupo4.linktracker.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@RestController
@RequestMapping("/link")
public class LinkController {

    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<LinkDTO> criar(@Valid @RequestBody LinkFormDTO linkFormDTO) {
        Link link = this.linkService.criarLink(linkFormDTO);

        return new ResponseEntity<LinkDTO>(LinkDTO.converter(link), HttpStatus.OK);
    }

    @GetMapping("/{linkId}")
    public RedirectView redirectView(@PathVariable Long linkId,
                                     @RequestHeader(value = "senha", defaultValue = "") String senha) {
        Link link = this.linkService.findLink(linkId, senha);

        return new RedirectView(link.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricDTO> obterMetricas(@PathVariable Long linkId) {
        Link link = this.linkService.obterMetricas(linkId);

        return new ResponseEntity<>(LinkMetricDTO.converter(link), HttpStatus.OK);
    }

    @PutMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkMetricDTO> invalidarLink(@PathVariable Long linkId) {
        Link link = this.linkService.invalidarLink(linkId);

        return new ResponseEntity<>(LinkMetricDTO.converter(link), HttpStatus.OK);
    }
}

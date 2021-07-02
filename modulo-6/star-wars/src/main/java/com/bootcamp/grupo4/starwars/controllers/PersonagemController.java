package com.bootcamp.grupo4.starwars.controllers;

import com.bootcamp.grupo4.starwars.entities.Personagem;
import com.bootcamp.grupo4.starwars.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    private final PersonagemService personagemService;

    @Autowired
    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @GetMapping("/search/{name}")
    public List<Personagem> findByName(@PathVariable String name) {
        return this.personagemService.findByName(name);
    }
}

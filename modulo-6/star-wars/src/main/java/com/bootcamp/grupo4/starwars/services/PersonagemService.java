package com.bootcamp.grupo4.starwars.services;

import com.bootcamp.grupo4.starwars.entities.Personagem;
import com.bootcamp.grupo4.starwars.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    @Autowired
    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public List<Personagem> findAll() {
        return this.personagemRepository.findAll();
    }

    public List<Personagem> findByName(String name) {
        return this.personagemRepository.findByNameIgnoreCase(name);
    }
}

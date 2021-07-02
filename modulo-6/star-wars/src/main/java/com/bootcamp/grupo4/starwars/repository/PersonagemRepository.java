package com.bootcamp.grupo4.starwars.repository;

import com.bootcamp.grupo4.starwars.entities.Personagem;
import com.bootcamp.grupo4.starwars.repository.dao.PersonagemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonagemRepository {

    private final PersonagemDAO personagemDAO;
    private final List<Personagem> personagemList;

    @Autowired
    public PersonagemRepository(PersonagemDAO personagemDAO) {
        this.personagemDAO = personagemDAO;
        this.personagemList = this.personagemDAO.findAll();
    }

    public List<Personagem> findAll() {
        return this.personagemList;
    }

    public List<Personagem> findByNameIgnoreCase(String name) {
        return this.personagemList.stream()
                .filter(p -> p.getName().toUpperCase().contains(name.toUpperCase()))
                .collect(Collectors.toList());
    }


}

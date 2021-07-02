package com.bootcamp.grupo4.starwars.repository.dao;

import com.bootcamp.grupo4.starwars.entities.Personagem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonagemDAO {

    private static final File DB = new File("starwars.json");
    private final ObjectMapper mapper;

    @Autowired
    public PersonagemDAO(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Personagem> findAll() {
        List<Personagem> personagens = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(DB);
            TypeReference<List<Personagem>> typeReference = new TypeReference<>() {};
            personagens = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personagens;
    }
}

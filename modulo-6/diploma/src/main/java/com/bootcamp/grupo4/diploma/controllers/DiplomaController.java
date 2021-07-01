package com.bootcamp.grupo4.diploma.controllers;

import com.bootcamp.grupo4.diploma.dtos.DiplomaDTO;
import com.bootcamp.grupo4.diploma.entities.Aluno;
import com.bootcamp.grupo4.diploma.services.DiplomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    @PostMapping
    public ResponseEntity<DiplomaDTO> gerarDiploma(@RequestBody Aluno aluno) {
        double media = DiplomaService.calcularMedia(aluno.getDisciplinas());

        return new ResponseEntity<>(new DiplomaDTO(media, aluno.getNome()), HttpStatus.OK);

    }
}

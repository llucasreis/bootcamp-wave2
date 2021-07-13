package com.bootcamp.grupo4.diploma.controllers;

import com.bootcamp.grupo4.diploma.dtos.DiplomaDTO;
import com.bootcamp.grupo4.diploma.dtos.StudentDTO;
import com.bootcamp.grupo4.diploma.services.DiplomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/analyzeNotes")
public class DiplomaController {

    @PostMapping
    public ResponseEntity<DiplomaDTO> gerarDiploma(@Valid @RequestBody StudentDTO studentDTO) {
        DiplomaDTO diplomaDTO = DiplomaService.calculateAverage(studentDTO);

        return new ResponseEntity<>(diplomaDTO, HttpStatus.CREATED);
    }
}

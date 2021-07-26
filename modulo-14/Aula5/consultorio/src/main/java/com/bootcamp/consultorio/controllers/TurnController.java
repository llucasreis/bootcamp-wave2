package com.bootcamp.consultorio.controllers;

import com.bootcamp.consultorio.domain.Turn;
import com.bootcamp.consultorio.domain.TurnStatus;
import com.bootcamp.consultorio.dtos.TurnFormDTO;
import com.bootcamp.consultorio.repositories.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnController {
    private final TurnRepository repository;

    @Autowired
    public TurnController(TurnRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Turn> create(@Valid @RequestBody TurnFormDTO formDTO) {
        Turn newTurn = this.repository.save(formDTO.convert());

        return new ResponseEntity<>(newTurn, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Turn> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/doctor/{lastName}")
    public List<Turn> findByDoctorLastName(@PathVariable String lastName) {
        return this.repository.findByDoctorLastName(lastName);
    }

    @GetMapping("/status/{status}")
    public List<Turn> findByStatus(@PathVariable String status) {
        TurnStatus turnStatus = TurnStatus.fromValue(status);

        return this.repository.findByStatus(turnStatus);
    }
}

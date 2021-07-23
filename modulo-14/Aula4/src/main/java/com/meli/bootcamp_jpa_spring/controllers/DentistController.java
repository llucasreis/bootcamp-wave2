package com.meli.bootcamp_jpa_spring.controllers;

import com.meli.bootcamp_jpa_spring.entities.Dentist;
import com.meli.bootcamp_jpa_spring.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dentists/")
public class DentistController {

    private DentistRepository dentistRepository;

    @Autowired
    public DentistController(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @GetMapping
    public void findDentists(){
        List<Dentist> dentistList = dentistRepository.listDentistsWithMoreThan2TurnsInADay();
        System.out.println(dentistList);
    }
}

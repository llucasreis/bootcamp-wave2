package com.meli.bootcamp_jpa_spring.controllers;

import com.meli.bootcamp_jpa_spring.entities.Patient;
import com.meli.bootcamp_jpa_spring.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("patient/")
public class PatientController {

    private PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("{data}")
    public void ListAllPatientsInOneDay(@PathVariable String data){
        List<Patient> a = patientRepository.findDistinctPatientByTurnsDay(LocalDate.parse(data));
        System.out.println(a);
    }
}

package com.meli.bootcamp_jpa_spring.repositories;

import com.meli.bootcamp_jpa_spring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findDistinctPatientByTurnsDay(LocalDate a);
}

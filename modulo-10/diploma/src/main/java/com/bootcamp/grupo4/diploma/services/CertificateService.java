package com.bootcamp.grupo4.diploma.services;

import com.bootcamp.grupo4.diploma.dtos.CertificateDTO;
import com.bootcamp.grupo4.diploma.dtos.StudentDTO;
import com.bootcamp.grupo4.diploma.entities.Student;
import com.bootcamp.grupo4.diploma.entities.Subject;

import java.util.List;

public interface CertificateService {
    CertificateDTO analyzeNotes(StudentDTO studentDTO);
    double calculateAverage(List<Subject> subjects);
    CertificateDTO writeDiploma(Student student, double average, String message);
    String withHonors(double average);
}

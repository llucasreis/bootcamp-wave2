package com.bootcamp.grupo4.diploma.services;

import com.bootcamp.grupo4.diploma.dtos.CertificateDTO;
import com.bootcamp.grupo4.diploma.dtos.StudentDTO;
import com.bootcamp.grupo4.diploma.dtos.SubjectDTO;
import com.bootcamp.grupo4.diploma.entities.Student;
import com.bootcamp.grupo4.diploma.entities.Subject;
import com.bootcamp.grupo4.diploma.utils.NumberUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Override
    public CertificateDTO analyzeNotes(StudentDTO studentDTO) {
        Student student = studentDTO.convert();

        if (student.getSubjects().size() == 0) {
            return this.writeDiploma(student, 0.0, "Reprovado.");
        }

        double average = this.calculateAverage(student.getSubjects());
        String message = this.withHonors(average);

        return this.writeDiploma(student, average, message);
    }

    @Override
    public double calculateAverage(List<Subject> subjects) {
        int size = subjects.size();

        double average = subjects.stream().mapToDouble(Subject::getNote).sum() / size;

        return NumberUtil.round(average, 1);
    }

    @Override
    public CertificateDTO writeDiploma(Student student, double average, String message) {
        return new CertificateDTO(average, student, message);
    }

    @Override
    public String withHonors(double average) {
        String message = "Sua média foi de " + average + ". ";

        if (average >= 7.0) {
            message += "Aprovado.";
            if (average > 9.0) {
                message += " Parabéns!";
            }
        } else {
            message += "Reprovado.";
        }

        return message;
    }
}

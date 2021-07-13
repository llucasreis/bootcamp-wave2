package com.bootcamp.grupo4.diploma.services;

import com.bootcamp.grupo4.diploma.dtos.DiplomaDTO;
import com.bootcamp.grupo4.diploma.dtos.StudentDTO;
import com.bootcamp.grupo4.diploma.dtos.SubjectDTO;
import com.bootcamp.grupo4.diploma.entities.Student;
import com.bootcamp.grupo4.diploma.utils.NumberUtil;

public class DiplomaService {

    public static DiplomaDTO calculateAverage(StudentDTO studentDTO) {
        int size = studentDTO.getSubjects().size();

        if (size == 0) throw new ArithmeticException("Não foi possível calcular a média");

        double average = studentDTO.getSubjects().stream().mapToDouble(SubjectDTO::getNote).sum() / size;

        Student student = studentDTO.convert();

        return new DiplomaDTO(NumberUtil.round(average, 1), student);
    }
}

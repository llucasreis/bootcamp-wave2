package com.bootcamp.grupo4.diploma.services;

import com.bootcamp.grupo4.diploma.entities.Disciplina;

import java.util.List;

public class DiplomaService {

    public static double calcularMedia(List<Disciplina> disciplinas) {
        return disciplinas.stream().mapToDouble(Disciplina::getNota).sum() / disciplinas.size();
    }
}

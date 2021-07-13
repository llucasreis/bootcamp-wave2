package com.bootcamp.grupo4.diploma.dtos;

import com.bootcamp.grupo4.diploma.entities.Student;

public class DiplomaDTO {
    private String message;
    private double average;
    private Student student;

    public DiplomaDTO() {
    }

    public DiplomaDTO(double average, Student student) {
        this.average = average;
        this.student = student;
        this.message = createMessage();
    }

    private String createMessage() {
        return "Sua média foi de " + this.average;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

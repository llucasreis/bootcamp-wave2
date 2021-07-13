package com.bootcamp.grupo4.diploma.dtos;

import com.bootcamp.grupo4.diploma.entities.Student;

public class CertificateDTO {
    private String message;
    private double average;
    private Student student;

    public CertificateDTO() {
    }

    public CertificateDTO(double average, Student student, String message) {
        this.average = average;
        this.student = student;
        this.message = message;
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

    @Override
    public String toString() {
        return "CertificateDTO{" +
                "message='" + message + '\'' +
                ", average=" + average +
                ", student=" + student +
                '}';
    }
}

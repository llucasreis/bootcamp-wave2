package com.bootcamp.grupo4.diploma.dtos;

import com.bootcamp.grupo4.diploma.entities.Subject;

import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectDTO {

    @NotBlank
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[A-Za-z_áíó]*$")
    private String subject;

    @NotNull
    @Min(value = 0)
    @Max(value = 99)
    private int note;

    public SubjectDTO() {
    }

    public SubjectDTO(String subject, int note) {
        this.subject = subject;
        this.note = note;
    }

    public Subject convert() {
        return new Subject(this.subject, this.note);
    }

    public static List<Subject> convert(List<SubjectDTO> subjectDTOS) {
        return subjectDTOS.stream().map(SubjectDTO::convert).collect(Collectors.toList());
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}

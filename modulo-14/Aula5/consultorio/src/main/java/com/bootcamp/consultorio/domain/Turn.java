package com.bootcamp.consultorio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "turns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turn {
    @Id
    private String id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private TurnStatus status;

    public Turn(Patient patient, Doctor doctor, String date, TurnStatus status) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }
}

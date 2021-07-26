package com.bootcamp.consultorio.dtos;

import com.bootcamp.consultorio.domain.Doctor;
import com.bootcamp.consultorio.domain.Patient;
import com.bootcamp.consultorio.domain.Turn;
import com.bootcamp.consultorio.domain.TurnStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnFormDTO {
    @NotNull
    @Valid
    private PatientFormDTO patient;
    @NotNull
    @Valid
    private DoctorFormDTO doctor;
    @NotBlank
    private String date;
    @NotBlank
    private String status;

    public Turn convert() {
        return new Turn(
                patient.convert(),
                doctor.convert(),
                this.date,
                TurnStatus.fromValue(this.status)
        );
    }
}

package com.bootcamp.consultorio.dtos;

import com.bootcamp.consultorio.domain.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorFormDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String specialty;

    public Doctor convert() {
        return new Doctor(this.firstName, this.lastName, this.specialty);
    }
}

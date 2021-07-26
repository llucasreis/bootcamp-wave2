package com.bootcamp.consultorio.dtos;

import com.bootcamp.consultorio.domain.Gender;
import com.bootcamp.consultorio.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientFormDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Integer age;
    @NotBlank
    private String gender;

    public Patient convert() {
        return new Patient(
                this.firstName,
                this.lastName,
                this.age,
                Gender.fromValue(gender)
        );
    }
}

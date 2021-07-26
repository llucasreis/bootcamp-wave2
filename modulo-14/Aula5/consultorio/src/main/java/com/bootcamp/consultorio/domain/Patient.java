package com.bootcamp.consultorio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
}

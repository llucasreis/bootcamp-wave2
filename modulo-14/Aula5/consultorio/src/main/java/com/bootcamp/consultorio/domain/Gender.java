package com.bootcamp.consultorio.domain;

public enum Gender {
    Male("M"), Female("F");
    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender fromValue(String value) {
        if (value != null) {
            for (Gender gender : values()) {
                if (gender.value.equals(value)) {
                    return gender;
                }
            }
        }
        throw new IllegalArgumentException("Gênero inválido");
    }

    public String toValue() {
        return value;
    }
}

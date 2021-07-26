package com.bootcamp.consultorio.domain;

public enum TurnStatus {
    CANCELADO("Cancelado"),
    ATIVO("Ativo");

    private final String value;

    TurnStatus(String value) {
        this.value = value;
    }

    public static TurnStatus fromValue(String value) {
        if (value != null) {
            for (TurnStatus turnStatus : values()) {
                if (turnStatus.value.equals(value)) {
                    return turnStatus;
                }
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }

    public String toValue() {
        return value;
    }
}

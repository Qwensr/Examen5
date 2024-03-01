package com.example.Examen.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ParkingStatus {
    IS_EMPTY("Is empty"),
    RESERVED("Reserved"),
    NOT_EMPTY("Is not empty");

    private final String DESCRIPTION;
}


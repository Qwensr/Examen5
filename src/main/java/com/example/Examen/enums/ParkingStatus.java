package com.example.Examen.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ParkingStatus {
    READ_ONLY("Read only"),
    DELETED("Deleted"),
    SAVING("Saving"),
    LOADING("Loading"),
    MANAGED("Managed"),
    GONE("Gone"),
    IS_EMPTY("Is empty"),
    RESERVED("Reserved"),
    NOT_EMPTY("Is not empty");

    private final String description;
}
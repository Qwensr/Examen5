package com.example.Examen.enums;

import lombok.*;


@AllArgsConstructor
@Getter
public enum  ParkingType {
    STANDARD("Standard"),
    FOR_DISABLED("For invalids"),
    FAMILIES("For family cars"),
    ELECTRIC_CARS("For electric cars");

    final String description;
}

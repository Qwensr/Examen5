package com.example.Examen.enums;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
public enum  ParkingType {
    STANDARD("Standard"),
    FOR_DISABLED("For invalids"),
    FAMILIES("For family cars"),
    ELECTRIC_CARS("For electric cars");

    final String description;
}

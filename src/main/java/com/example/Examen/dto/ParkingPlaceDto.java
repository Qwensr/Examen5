package com.example.Examen.dto;

import com.example.Examen.enums.ParkingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.spi.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ParkingPlaceDto {
        private Long id;
        private String spotNumber;
        private ParkingType parkingType;
        private Status status;
}

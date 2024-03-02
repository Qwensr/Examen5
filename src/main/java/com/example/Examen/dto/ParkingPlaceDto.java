package com.example.Examen.dto;

import com.example.Examen.enums.ParkingType;
import lombok.*;
import org.hibernate.engine.spi.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ParkingPlaceDto {
        private Long id;
        private String spotNumber;
        private ParkingType parkingType;
        private Status status;
        private Long userID;

}

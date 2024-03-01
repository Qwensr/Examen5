package com.example.Examen.entity;

import com.example.Examen.enums.ParkingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.spi.Status;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingPlaceEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String spotNumber;
    private ParkingType parkingType;
    private Status status;

}

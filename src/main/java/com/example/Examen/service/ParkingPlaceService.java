package com.example.Examen.service;

import com.example.Examen.dto.ParkingPlaceDto;
import com.example.Examen.enums.ParkingType;

import java.util.List;

public interface ParkingPlaceService {
    List<ParkingPlaceDto> findAll();
    ParkingPlaceDto findById(Long id);
    List<ParkingPlaceDto> findNotReservedPlaces();
    List<ParkingPlaceDto> findPlacesByParkingType(ParkingType parkingType);

    ParkingPlaceDto create(ParkingPlaceDto parkingPlaceToCreate);

    void delete(Long id);


}

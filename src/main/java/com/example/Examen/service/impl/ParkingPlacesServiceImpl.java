package com.example.Examen.service.impl;

import com.example.Examen.dto.ParkingPlaceDto;
import com.example.Examen.entity.ParkingPlaceEntity;
import com.example.Examen.enums.ParkingStatus;
import com.example.Examen.enums.ParkingType;
import com.example.Examen.repo.ParkingPlaceRepo;
import com.example.Examen.service.ParkingPlaceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ParkingPlacesServiceImpl implements ParkingPlaceService {

    private final ParkingPlaceRepo repo;
    @Override
    public List<ParkingPlaceDto> findAll() {
        List<ParkingPlaceEntity> parkingPlaceEntities = repo.findAll();

        List<ParkingPlaceDto> parkingPlaceDtos = new ArrayList<>();
        for(ParkingPlaceEntity parkingPlace : parkingPlaceEntities){
            ParkingPlaceDto parkingPlaceDto = ParkingPlaceDto.builder()
                    .id(parkingPlace.getId())
                    .spotNumber(parkingPlace.getSpotNumber())
                    .parkingType(parkingPlace.getParkingType())
                    .status(parkingPlace.getStatus())
                    .build();
            parkingPlaceDtos.add(parkingPlaceDto);
        }
        return parkingPlaceDtos;
    }

    @Override
    public ParkingPlaceDto findById(Long id) {
        ParkingPlaceEntity parkingPlaceEntity = repo.findById(id).orElseThrow(()->new EntityNotFoundException(""));

        return ParkingPlaceDto.builder()
                .id(parkingPlaceEntity.getId())
                .spotNumber(parkingPlaceEntity.getSpotNumber())
                .parkingType(parkingPlaceEntity.getParkingType())
                .status(parkingPlaceEntity.getStatus())
                .build();
    }

    @Override
    public List<ParkingPlaceDto> findNotReservedPlaces() {
        List<ParkingPlaceEntity> parkingPlaceEntities = repo.findAllNotReserved(ParkingStatus.IS_EMPTY);

        List<ParkingPlaceDto> parkingPlaceDtos = new ArrayList<>();
        for(ParkingPlaceEntity parkingPlace : parkingPlaceEntities){
            ParkingPlaceDto parkingPlaceDto = ParkingPlaceDto.builder()
                    .id(parkingPlace.getId())
                    .spotNumber(parkingPlace.getSpotNumber())
                    .parkingType(parkingPlace.getParkingType())
                    .status(parkingPlace.getStatus())
                    .build();
            parkingPlaceDtos.add(parkingPlaceDto);
        }
        return parkingPlaceDtos;

    }

    @Override
    public List<ParkingPlaceDto> findPlacesByParkingType(ParkingType parkingType) {
        List<ParkingPlaceEntity> parkingPlaceEntities = repo.findParkingPlaceByType(parkingType);

        List<ParkingPlaceDto> parkingPlaceDtos = new ArrayList<>();
        for(ParkingPlaceEntity parkingPlace : parkingPlaceEntities){
            ParkingPlaceDto parkingPlaceDto = ParkingPlaceDto.builder()
                    .id(parkingPlace.getId())
                    .spotNumber(parkingPlace.getSpotNumber())
                    .parkingType(parkingPlace.getParkingType())
                    .status(parkingPlace.getStatus())
                    .build();
            parkingPlaceDtos.add(parkingPlaceDto);
        }
        return parkingPlaceDtos;
    }

    @Override
    public ParkingPlaceDto create(ParkingPlaceDto parkingPlaceToCreate) {
        ParkingPlaceEntity parkingPlaceEntity = ParkingPlaceEntity.builder()
                .id(parkingPlaceToCreate.getId())
                .spotNumber(parkingPlaceToCreate.getSpotNumber())
                .parkingType(parkingPlaceToCreate.getParkingType())
                .status(parkingPlaceToCreate.getStatus())
                .build();

        try{
            repo.save(parkingPlaceEntity);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return parkingPlaceToCreate;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
package com.example.Examen.service.impl;

import com.example.Examen.dto.ParkingPlaceDto;
import com.example.Examen.entity.ParkingPlaceEntity;
import com.example.Examen.entity.UserEntity;
import com.example.Examen.enums.ParkingStatus;
import com.example.Examen.enums.ParkingType;
import com.example.Examen.repo.ParkingPlaceRepo;
import com.example.Examen.repo.UserRepo;
import com.example.Examen.service.ParkingPlaceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class ParkingPlacesServiceImpl implements ParkingPlaceService {

    private final ParkingPlaceRepo repo;
    private final UserRepo userRepo;

    @Override
    public List<ParkingPlaceDto> findAll() {
        List<ParkingPlaceEntity> parkingPlaceEntities = repo.findAll();

        return getParkingPlaceDtos(parkingPlaceEntities);
    }

    @Override
    public ParkingPlaceDto findById(Long id) {
        ParkingPlaceEntity parkingPlaceEntity = repo.findById(id).orElseThrow(() -> new EntityNotFoundException(""));

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

        return getParkingPlaceDtos(parkingPlaceEntities);

    }

    @Override
    public List<ParkingPlaceDto> findPlacesByParkingType(ParkingType parkingType) {
        List<ParkingPlaceEntity> parkingPlaceEntities = repo.findParkingPlaceByType(parkingType);

        return getParkingPlaceDtos(parkingPlaceEntities);
    }

    private List<ParkingPlaceDto> getParkingPlaceDtos(List<ParkingPlaceEntity> parkingPlaceEntities) {
        List<ParkingPlaceDto> parkingPlaceDtos = new ArrayList<>();
        for (ParkingPlaceEntity parkingPlace : parkingPlaceEntities) {
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
        Long userId = parkingPlaceToCreate.getUserID();

        if (userId != null) {
            Optional<UserEntity> userEntityOptional = userRepo.findById(userId);
            if (userEntityOptional.isPresent()) {
                ParkingPlaceEntity parkingPlaceEntity = new ParkingPlaceEntity();
                parkingPlaceEntity.setSpotNumber(parkingPlaceToCreate.getSpotNumber());
                parkingPlaceEntity.setParkingType(parkingPlaceToCreate.getParkingType());
                parkingPlaceEntity.setStatus(parkingPlaceToCreate.getStatus());
                parkingPlaceEntity.setUser(userEntityOptional.get());

                ParkingPlaceEntity savedEntity = repo.save(parkingPlaceEntity);

                UserEntity userEntity = userEntityOptional.get();
                userEntity.getParkingPlaces().add(savedEntity);
                userRepo.save(userEntity);

                return ParkingPlaceDto.builder()
                        .id(savedEntity.getId())
                        .spotNumber(savedEntity.getSpotNumber())
                        .parkingType(savedEntity.getParkingType())
                        .status(savedEntity.getStatus())
                        .build();
            } else {
                System.out.println("User with ID " + userId + " not found");
                return null;
            }
        } else {
            System.out.println("User ID is null");
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
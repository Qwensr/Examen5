package com.example.Examen.service;

import com.example.Examen.dto.UserParkingPlaceDto;
import com.example.Examen.entity.ParkingPlaceEntity;
import com.example.Examen.entity.UserEntity;

import java.util.List;

public interface UserParkingPlaceService {

    UserParkingPlaceDto create(UserParkingPlaceDto userParkingPlaceDto);
    List<UserParkingPlaceDto> findAll();
    UserParkingPlaceDto findById(Long id);

    void createUserParkingPlace(UserEntity userEntity, ParkingPlaceEntity parkingPlaceEntity);

    void delete(Long id);
}

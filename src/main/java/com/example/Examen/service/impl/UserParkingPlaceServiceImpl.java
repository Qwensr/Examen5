package com.example.Examen.service.impl;

import com.example.Examen.dto.UserParkingPlaceDto;
import com.example.Examen.entity.ParkingPlaceEntity;
import com.example.Examen.entity.UserEntity;
import com.example.Examen.entity.UserParkingPlaceEntity;
import com.example.Examen.repo.UserParkingPlaceRepo;
import com.example.Examen.service.UserParkingPlaceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserParkingPlaceServiceImpl implements UserParkingPlaceService {

    private final UserParkingPlaceRepo repo;
    @Override
    public UserParkingPlaceDto create(UserParkingPlaceDto userParkingPlaceDto) {
        UserParkingPlaceEntity userParkingPlaceEntity = convertToEntity(userParkingPlaceDto);
        UserParkingPlaceEntity createdEntity = repo.save(userParkingPlaceEntity);
        return convertToDto(createdEntity);
    }

    @Override
    public List<UserParkingPlaceDto> findAll() {
        List<UserParkingPlaceEntity> entities = repo.findAll();
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserParkingPlaceDto findById(Long id) {
        UserParkingPlaceEntity entity = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserParkingPlaceEntity not found with id: " + id));
        return convertToDto(entity);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    private UserParkingPlaceEntity convertToEntity(UserParkingPlaceDto userParkingPlaceDto) {
        UserParkingPlaceEntity entity = new UserParkingPlaceEntity();
        entity.setUser(userParkingPlaceDto.getUserId());
        entity.setParkingPlace(userParkingPlaceDto.getParkingPlaceId());
        return entity;
    }
    @Override
    public void createUserParkingPlace(UserEntity userEntity, ParkingPlaceEntity parkingPlaceEntity) {
        UserParkingPlaceEntity userParkingPlaceEntity = UserParkingPlaceEntity.builder()
                .user(userEntity)
                .parkingPlace(parkingPlaceEntity)
                .build();
        repo.save(userParkingPlaceEntity);
    }

    private UserParkingPlaceDto convertToDto(UserParkingPlaceEntity entity) {
        UserParkingPlaceDto dto = new UserParkingPlaceDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUser());
        dto.setParkingPlaceId(entity.getParkingPlace());
        return dto;
    }
}
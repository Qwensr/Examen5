package com.example.Examen.repo;

import com.example.Examen.entity.UserParkingPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserParkingPlaceRepo extends JpaRepository<UserParkingPlaceEntity, Long> {
}

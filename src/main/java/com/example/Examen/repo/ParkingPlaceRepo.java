package com.example.Examen.repo;


import com.example.Examen.entity.ParkingPlaceEntity;
import com.example.Examen.enums.ParkingStatus;
import com.example.Examen.enums.ParkingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParkingPlaceRepo extends JpaRepository<ParkingPlaceEntity, Long> {
    @Query("select p from ParkingPlaceEntity p " +
            "where p.status = :status")
    List<ParkingPlaceEntity> findAllNotReserved(@Param("status") ParkingStatus status);

    @Query("select p from ParkingPlaceEntity p " +
            "where p.parkingType = :type ")
    List<ParkingPlaceEntity> findParkingPlaceByType(@Param("type")ParkingType type);
}
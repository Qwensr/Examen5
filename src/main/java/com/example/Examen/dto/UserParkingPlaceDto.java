package com.example.Examen.dto;

import com.example.Examen.entity.ParkingPlaceEntity;
import com.example.Examen.entity.UserEntity;
import lombok.*;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
public class UserParkingPlaceDto {
    private Long id;
    private UserEntity userId;
    private ParkingPlaceEntity parkingPlaceId;

}

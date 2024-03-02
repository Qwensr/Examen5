package com.example.Examen.controller;

import com.example.Examen.dto.UserParkingPlaceDto;
import com.example.Examen.service.UserParkingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-parking-places")
@RequiredArgsConstructor
public class UserParkingPlaceController {

    private final UserParkingPlaceService userParkingPlaceService;

    @GetMapping("/findAll")
    public List<UserParkingPlaceDto> findAllUserParkingPlaces() {
        return userParkingPlaceService.findAll();
    }

    @GetMapping("/findById/{id}")
    public UserParkingPlaceDto findUserParkingPlaceById(@PathVariable Long id) {
        return userParkingPlaceService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<UserParkingPlaceDto> createUserParkingPlace(@RequestBody UserParkingPlaceDto userParkingPlaceDto) {
        UserParkingPlaceDto createdUserParkingPlace = userParkingPlaceService.create(userParkingPlaceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserParkingPlace);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserParkingPlaceById(@PathVariable Long id) {
        userParkingPlaceService.delete(id);
    }
}

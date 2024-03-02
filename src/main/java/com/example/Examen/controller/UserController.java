package com.example.Examen.controller;

import com.example.Examen.dto.UserDto;
import com.example.Examen.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users/")
public class UserController {

    private final UserServiceImpl service;

    @PostMapping("create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userToCreate){
        UserDto createdUser = service.create(userToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("findAll")
    public List<UserDto> findAll(){
        return service.findAll();
    }

    @GetMapping("findById/{id}")
    public UserDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("delete")
    public void deleteById(@RequestParam Long id){
        service.delete(id);
    }
}

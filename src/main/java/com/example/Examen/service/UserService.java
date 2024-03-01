package com.example.Examen.service;

import com.example.Examen.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto userToCreate);
    List<UserDto> findAll();
    UserDto findById(Long id);

    void delete(Long id);


}

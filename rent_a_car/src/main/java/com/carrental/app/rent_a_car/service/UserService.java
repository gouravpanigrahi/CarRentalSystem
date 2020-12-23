package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getUsers();

    UserDto getUser(long id);

    UserDto updateUser(UserDto userDto);

    void deleteUser(long id);
}

package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.dto.UserDto;
import com.carrental.app.rent_a_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to user ...";
    }

    @PostMapping(value = "createUser")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "getUser/{id}")
    public UserDto getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @GetMapping(value = "deleteUser/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}

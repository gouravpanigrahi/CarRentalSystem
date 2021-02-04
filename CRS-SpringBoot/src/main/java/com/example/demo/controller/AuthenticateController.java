package com.example.demo.controller;

import com.example.demo.model.LoginModel;
import com.example.demo.model.ResponseModel;
import com.example.demo.model.User;
import com.example.demo.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
public class AuthenticateController {

    @Autowired
    AuthenticateService authenticateService;

    @PostMapping("/authenticate")
    public ResponseModel authenticate(@RequestBody LoginModel loginModel){
        return authenticateService.authenticate(loginModel);
    }

    @GetMapping("/getRole/{username}")
    public User getRole(@PathVariable String username){
        return authenticateService.getRole(username);
    }

    @PostMapping("/signup")
    public ResponseModel signUp(@RequestBody User user){
        System.out.println(user);
        return authenticateService.signUp(user);
    }
}

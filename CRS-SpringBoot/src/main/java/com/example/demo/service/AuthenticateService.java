package com.example.demo.service;


import com.example.demo.model.LoginModel;
import com.example.demo.model.ResponseModel;
import com.example.demo.model.User;

public interface AuthenticateService {

    ResponseModel authenticate(LoginModel loginModel);
    User getRole(String username);
    ResponseModel signUp(User user);

}

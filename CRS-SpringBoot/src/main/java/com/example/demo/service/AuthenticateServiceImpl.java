package com.example.demo.service;

import com.example.demo.dao.AuthenticDao;
import com.example.demo.model.LoginModel;
import com.example.demo.model.ResponseModel;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl implements AuthenticateService{

    @Autowired
    AuthenticDao authenticDao;

    @Override
    public ResponseModel authenticate(LoginModel loginModel) {
        User existingUser = authenticDao.findByUserName( loginModel.getUsername());
        if(existingUser.getUserPassword().equals(loginModel.getPassword())){
            return new ResponseModel("Authentication success",true);
        }else {
            return new ResponseModel("Authentication Failed",false);
        }
    }

    @Override
    public User getRole(String userName) {
       return authenticDao.findByUserName(userName);
    }

    @Override
    public ResponseModel signUp(User user) {
        user.setRoles("ROLE_CUSTOMER");
       authenticDao.save(user);
       return new ResponseModel("User Added Successfully",true);
    }
}

package com.service;

import com.dao.UserRepo;

public class UserService  {

    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }



}

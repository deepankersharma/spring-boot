package com.dao;

import com.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServiceDao {


    @Autowired
    private UserRepo userRepo;


    @Override
    public User loadByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}

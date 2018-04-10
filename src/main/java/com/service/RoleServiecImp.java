package com.service;

import com.dao.RoleRepo;
import com.modal.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleServiecImp {

    private final RoleRepo roleRepo;

    public RoleServiecImp(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }

    public List<Role> findAll(){
        List<Role> roles = new ArrayList<Role>();
        roles = (List<Role>) this.roleRepo.findAll();
        return roles;
    }

    public Role save(Role role){
        return this.roleRepo.save(role);
    }
}

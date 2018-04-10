package com.config;

import com.dao.RoleRepo;
import com.modal.Role;
import com.service.RoleServiecImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.modal.RoleConstraint.AdminRole;
import static com.modal.RoleConstraint.SuerAdminRole;
import static com.modal.RoleConstraint.UserRole;

@Component
public class BootStrap implements ApplicationListener<ApplicationReadyEvent> {


    @Autowired
    private RoleRepo roleServiecImp;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

/*
        List<Role> roles = (List<Role>) roleServiecImp.findAll();

        Role role = null;
        if(roles.size() == 0){
            role = new Role();
            role.setAuthority(SuerAdminRole);
            role.setDescription(SuerAdminRole);
            role.setStatus(true);
            roleServiecImp.save(role);

            role = new Role();
            role.setAuthority(AdminRole);
            role.setDescription(AdminRole);
            role.setStatus(true);
            roleServiecImp.save(role);

            role = new Role();
            role.setAuthority(UserRole);
            role.setDescription(UserRole);
            role.setStatus(true);
            roleServiecImp.save(role);
        }*/
    }
}

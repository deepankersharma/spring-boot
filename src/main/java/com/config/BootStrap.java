package com.config;

import com.dao.RoleRepo;
import com.dao.UserRepo;
import com.dao.UserRoleRepo;
import com.modal.Role;
import com.modal.User;
import com.modal.UserRole;
import com.service.RoleServiecImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.modal.RoleConstraint.AdminRole;
import static com.modal.RoleConstraint.SuerAdminRole;
import static com.modal.RoleConstraint.UserRole;

@Component
public class BootStrap implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RoleRepo roleServiecImp;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

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
        }


        int countUser = (int) userRepo.count();

        System.out.println("count : "+countUser);

        if(countUser == 0){


            User user = new User();
            user.setFname("Deepanker");
            user.setLname("Deepanker");
            user.setAccountExpired(false);
            user.setAccountLocked(false);
            user.setEmail("deepankersharma555@gmail.com");
            user.setIs_enabled(true);
            user.setSuperAdmin(true);
            user.setUsername("deepanker");
            user.setPassword("password");
            user.setCreatedDate(new Date());
            user.setUpdatedDate(new Date());

            Set<UserRole> userROleList= new HashSet<UserRole>();
            UserRole userRole = new UserRole();
            Role role1 =  roleServiecImp.findByAuthority(UserRole);

            userRole.setRole(role1.getId());
            userRole.setUser(user);
            userROleList.add(userRole);

            UserRole userRole1 = new UserRole();
            role1 =  roleServiecImp.findByAuthority(AdminRole);

            userRole1.setRole(role1.getId());
            userRole1.setUser(user);
            userROleList.add(userRole1);

            user.setRoles(userROleList);
            userRepo.save(user);
            userRoleRepo.save(userRole1);
            userRoleRepo.save(userRole);
        }
    }
}

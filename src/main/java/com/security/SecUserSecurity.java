package com.security;

import com.dao.RoleRepo;
import com.dao.UserRepo;
import com.dao.UserServiceImp;
import com.modal.Role;
import com.modal.SecUser;
import com.modal.User;
import com.modal.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class SecUserSecurity implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @Autowired
    private UserServiceImp userServiceImp;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userServiceImp.loadByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<UserRole> roles = user.getRoles();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        for (UserRole role : roles) {
            Role role1 = roleRepo.findById(role.getRole());
                grantedAuthorities.add(new SimpleGrantedAuthority(role1.getAuthority()));
        }

        SecUser secUser = new SecUser(user.getUsername() ,   user.getPassword(), true, !user.isAccountExpired(),! user.isPasswordExpired(), !user.isAccountLocked() , grantedAuthorities);
        return secUser;

    }


}

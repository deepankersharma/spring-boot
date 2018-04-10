package com.modal;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class SecUser implements UserDetails , Serializable {
    private static final long serialVersionUID = 97514355663109919L;
    private final java.lang.String username;
    private java.lang.String password;
    private final boolean enabled;
    private final boolean credentialsNonExpired;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final java.util.Set<org.springframework.security.core.GrantedAuthority> authorities;


    public SecUser(String username, String password, boolean enabled, boolean credentialsNonExpired, boolean accountNonExpired, boolean accountNonLocked, Set<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = authorities;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }



}

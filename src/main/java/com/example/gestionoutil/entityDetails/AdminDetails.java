package com.example.gestionoutil.entityDetails;

import com.example.gestionoutil.entity.MyAdminEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class AdminDetails implements UserDetails {
    private MyAdminEntity admin;

    public AdminDetails(MyAdminEntity admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("admin");
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return admin.getMotDepasse();
    }

    @Override
    public String getUsername() {
        return admin.getMotDepasse();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true ;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

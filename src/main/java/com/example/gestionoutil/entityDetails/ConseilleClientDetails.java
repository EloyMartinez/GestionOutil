package com.example.gestionoutil.entityDetails;

import com.example.gestionoutil.entity.MyAdminEntity;
import com.example.gestionoutil.entity.MyConseilleClientEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class ConseilleClientDetails implements UserDetails {
    private MyConseilleClientEntity conseilleClient;

    public ConseilleClientDetails(MyConseilleClientEntity conseilleClient) {
        this.conseilleClient = conseilleClient;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("conseilleClient");
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return conseilleClient.getMotDepasse();
    }

    @Override
    public String getUsername() {
        return conseilleClient.getMotDepasse();
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

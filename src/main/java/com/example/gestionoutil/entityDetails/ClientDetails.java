package com.example.gestionoutil.entityDetails;

import com.example.gestionoutil.entity.MyClientEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class ClientDetails implements UserDetails {
    private MyClientEntity client;

    public ClientDetails(MyClientEntity client) {
        this.client = client;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("client");
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return client.getMdpcli();
    }

    @Override
    public String getUsername() {
        return client.getCourrielcli();
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

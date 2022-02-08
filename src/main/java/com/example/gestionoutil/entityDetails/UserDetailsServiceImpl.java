package com.example.gestionoutil.entityDetails;

import com.example.gestionoutil.entity.MyAdminEntity;
import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.entity.MyConseilleClientEntity;
import com.example.gestionoutil.repositories.AdminRepository;
import com.example.gestionoutil.repositories.ClientRepository;
import com.example.gestionoutil.repositories.ConseilleClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ConseilleClientRepository conseilleClientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyClientEntity client = clientRepository.getClientByEmail(username);
        if(client != null)
            return new ClientDetails(client);
        MyAdminEntity admin = adminRepository.getAdmintByEmail(username);
        if (admin != null)
            return new AdminDetails(admin);
        MyConseilleClientEntity conseilleClient = conseilleClientRepository.getConseilleByEmail(username);
        if (conseilleClient != null)
            return new ConseilleClientDetails(conseilleClient);
        throw new UsernameNotFoundException("Impossible de trouver cet utilisateur");
    }
}

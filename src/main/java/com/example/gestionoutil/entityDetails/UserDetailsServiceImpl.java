package com.example.gestionoutil.entityDetails;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    /*@Autowired
    private ClientRepository clientRepository;*/

    @Autowired
    private ClientDAO clientDAO = new ClientDAO();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyClientEntity client = clientDAO.getClientByEmail(username);
        if (client != null)
            return new ClientDetails(client);
        throw new UsernameNotFoundException("Impossible de trouver cet utilisateur");
    }
}

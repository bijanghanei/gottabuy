package com.bijanghanei.GottaBuy.security;

import com.bijanghanei.GottaBuy.model.entity.GottaBuyUser;
import com.bijanghanei.GottaBuy.repository.GottaBuyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GottaBuyUserDetailsService implements UserDetailsService {
    @Autowired
    private GottaBuyUserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GottaBuyUser user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + "not found!");
        }
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}

package com.demobackend.services;

import com.demobackend.database.model.MyUserPrinciple;
import com.demobackend.database.model.User;
import com.demobackend.database.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    //Override loadUserByUsername to load User from database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findWithUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrinciple(user);
    }

}

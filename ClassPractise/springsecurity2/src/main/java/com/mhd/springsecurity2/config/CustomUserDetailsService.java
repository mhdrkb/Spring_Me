package com.mhd.springsecurity2.config;

import com.mhd.springsecurity2.entity.User;
import com.mhd.springsecurity2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);//to get user list from database using customUserDetailsService
        optionalUser.orElseThrow(()->new UsernameNotFoundException("Username not found.")); // if it gets null username , no users in the list
        return optionalUser.map(CustomUserDetails :: new).get();
    }
}

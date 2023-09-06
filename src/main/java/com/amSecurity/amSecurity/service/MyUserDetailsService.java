package com.amSecurity.amSecurity.service;

import com.amSecurity.amSecurity.entity.User;
import com.amSecurity.amSecurity.repository.UserRepository;
import com.amSecurity.amSecurity.util.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("--------------------- User service ----------------------------");

        User user = userRepository.findByUser_name(username);
        if (user == null){
            throw new UsernameNotFoundException("Not found :"+ username);
        }
        System.out.println("------------------------------------------");
        System.out.println("user name : "+user.getUser_name());
        System.out.println("user password : "+user.getPassword());
        System.out.println("user Role : "+user.getRoles());
        System.out.println("------------------------------------------");

        return new MyUserDetails(user);
    }
}

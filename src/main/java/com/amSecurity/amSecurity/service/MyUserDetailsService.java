package com.amSecurity.amSecurity.service;

import com.amSecurity.amSecurity.entity.User;
import com.amSecurity.amSecurity.repository.UserRepository;
import com.amSecurity.amSecurity.util.MyUserDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        log.info("--- User service ---");
        User user = userRepository.findByUser_name(username);
        if (user == null){
            throw new UsernameNotFoundException("Not found :"+ username);
        }
        log.info("UserName : {}, password : {}, Role : {}",user.getUser_name(),user.getPassword(),user.getRoles());

        return new MyUserDetails(user);
    }
}

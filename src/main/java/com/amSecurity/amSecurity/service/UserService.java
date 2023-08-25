package com.amSecurity.amSecurity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    List findAll();

    User save(User user);

    void delete(Long id);
}

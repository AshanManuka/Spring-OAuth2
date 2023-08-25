package com.amSecurity.amSecurity.service;

import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserService {
    List findAll();

    User save(User user);

    void delete(Long id);
}

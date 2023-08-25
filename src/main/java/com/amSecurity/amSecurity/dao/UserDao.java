package com.amSecurity.amSecurity.dao;

import org.springframework.security.core.userdetails.User;

public interface UserDao {
    User findByUsername(String userId);

    Iterable<Object> findAll();
}

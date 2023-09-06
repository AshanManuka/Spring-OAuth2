package com.amSecurity.amSecurity.repository;

import com.amSecurity.amSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.user_name=?1")
    User findByUser_name(String userName);
}

package com.amSecurity.amSecurity.service;

import com.amSecurity.amSecurity.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    static{
        System.out.println("----------------------------ServiceImpl----------------------------");
    }

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("------------------- user loading -----------------");
        User user1;
        com.amSecurity.amSecurity.entity.User user = userRepository.findUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }else{
            user1 = modelMapper.map(user,User.class);
        }
        return new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}

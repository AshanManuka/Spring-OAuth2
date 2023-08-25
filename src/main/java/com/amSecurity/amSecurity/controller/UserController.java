package com.amSecurity.amSecurity.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping
    @RequestMapping(value="/user")
    public List listUser(){
        return userService.findAll();
    }

    @PostMapping
    @RequestMapping(value = "/user")
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping
    @RequestMapping(value = "/user/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return "success";
    }

}

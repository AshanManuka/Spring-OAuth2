package com.amSecurity.amSecurity.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @GetMapping("/")
    public String welcomeMethod(){
        return "<h1> Welcome to Demo Application!!</h1>";
    }

    @GetMapping("/user")
    public String welcomeUser(){
        return "<h1> Welcome System User to Demo Application!!</h1>";
    }

    @GetMapping("/admin")
    public String welcomeAdmin(){
        return "<h1> Welcome System Admin to Demo Application!!</h1>";
    }


}
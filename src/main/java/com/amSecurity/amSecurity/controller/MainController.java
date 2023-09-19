package com.amSecurity.amSecurity.controller;

import com.amSecurity.amSecurity.model.AuthenticationRequest;
import com.amSecurity.amSecurity.model.AuthenticationResponse;
import com.amSecurity.amSecurity.service.MyUserDetailsService;
import com.amSecurity.amSecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/loggedUser")
    public String welcomeLoggedUser(){
        return "<h1> Welcome System User to Demo Application!!</h1>";
    }

    @GetMapping("/otherUser")
    public String welcomeOtherUser(){
        return "<h1> Welcome Foreign User to Demo Application!!</h1>";
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authRequest)throws Exception{

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword())
            );
        }catch (BadCredentialsException exception){
            throw new Exception("Incorrect UserName or Password -> ",exception);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }


}
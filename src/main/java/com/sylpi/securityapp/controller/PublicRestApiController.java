package com.sylpi.securityapp.controller;

import com.sylpi.securityapp.model.User;
import com.sylpi.securityapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("test1")
    public String test1(){ return "API TEST 1";}

    @GetMapping("test2")
    public String test2(){ return "API TEST 2";}

    @GetMapping("users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
}

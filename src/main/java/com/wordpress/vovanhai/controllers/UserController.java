package com.wordpress.vovanhai.controllers;

import com.wordpress.vovanhai.models.UserInfo;
import com.wordpress.vovanhai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }
   /* @GetMapping("/n")
    public String addU() {
        UserInfo userInfo =new UserInfo(100,"xx","teo@gmail.com","12345","ADMIN");
        return userService.addUser(userInfo);
    }*/

    @GetMapping("/principal")
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }
}
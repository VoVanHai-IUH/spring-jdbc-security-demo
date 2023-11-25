package com.wordpress.vovanhai.controllers;

import com.wordpress.vovanhai.services.JdbcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class JdbcUserController {
    @Autowired
    private JdbcUserService jdbcUserService;
    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDetails> add(@RequestBody UserDetails userDetails){
        return ResponseEntity.ok(jdbcUserService.addUser(userDetails));
    }
    @PostMapping("/change-psw")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDetails> changePsw(@RequestBody ChangePassInfo us){
        return ResponseEntity.ok(jdbcUserService.changePassword(us.username(), us.newPass(),us.oldPass()));
    }
    @DeleteMapping("/del/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDetails> del(@PathVariable("username")String username){
        return ResponseEntity.ok(jdbcUserService.deleteUser(username));
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDetails> getByName(@PathVariable("username") String username){
        return ResponseEntity.ok(jdbcUserService.getByName(username));
    }
}



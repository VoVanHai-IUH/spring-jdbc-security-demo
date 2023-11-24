package com.wordpress.vovanhai.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "app_user")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Column(name = "email",unique = true, nullable = false, length = 150)
    private String email;
    private boolean enable = true;

    public AppUser(String username, String password, String email, boolean enable) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }
}

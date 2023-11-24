package com.wordpress.vovanhai;

import com.wordpress.vovanhai.models.UserInfo;
import com.wordpress.vovanhai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJdbcSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcSecurityDemoApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Bean
    CommandLineRunner abc() {
        return args -> {
            UserInfo teo = new UserInfo("teo", "teo@gmail.com", "teo", "ADMIN");
            UserInfo ty = new UserInfo("ty", "ty@gmail.com", "ty", "USER");
            userService.addUser(teo);
            userService.addUser(ty);
        };
    }
}

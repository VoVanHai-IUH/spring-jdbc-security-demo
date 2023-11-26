package com.wordpress.vovanhai;

import com.wordpress.vovanhai.services.JdbcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringJdbcSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcSecurityDemoApplication.class, args);
    }

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JdbcUserService jdbcUserService;

    @Bean
    CommandLineRunner forDefaultUser() {
        return args -> {

            UserDetails teo=User.withUsername("teo")
                    .password(encoder.encode("teo"))
                    .roles("ADMIN")
                    .build()
                    ;
            UserDetails ty=User.withUsername("ty")
                    .password(encoder.encode("ty"))
                    .roles("USER")
                    .build()
                    ;

            jdbcUserService.addUser(teo);
            jdbcUserService.addUser(ty);
        };
    }
}

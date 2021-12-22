package com.rocktecj.springbootjwtdemo;

import com.rocktecj.springbootjwtdemo.domain.Role;
import com.rocktecj.springbootjwtdemo.domain.User;
import com.rocktecj.springbootjwtdemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication

public class SpringbootJwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJwtDemoApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner (UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"USER"));
            userService.saveRole(new Role(null,"MANAGER"));
            userService.saveRole(new Role(null,"ADMIN"));
            userService.saveRole(new Role(null,"SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Doe", "johndoe", "122", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "john", "123", new ArrayList<>()));
            userService.saveUser(new User(null, "John Doe", "doe", "124", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim", "125", new ArrayList<>()));

            userService.addRoleToUser("johndoe", "USER");
            userService.addRoleToUser("johndoe", "ADMIN");
            userService.addRoleToUser("johndoe", "SUPER_ADMIN");
            userService.addRoleToUser("jim", "MANAGER");
            userService.addRoleToUser("doe", "ADMIN");
            userService.addRoleToUser("john", "MANAGER");
            userService.addRoleToUser("john", "ADMIN");
            userService.addRoleToUser("john", "SUPER_ADMIN");
        };
    }
}

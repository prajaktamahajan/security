package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserLogger implements CommandLineRunner {

    private final InMemoryUserDetailsManager userDetailsService;

    public DefaultUserLogger(InMemoryUserDetailsManager userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void run(String... args) throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("test123")
                .roles("USER")
                .build();
        userDetailsService.createUser(user);
        System.out.println("Default user created here: user / test123");
    }
}


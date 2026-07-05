package com.Livraria.livraria.infra;

import com.Livraria.livraria.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader implements CommandLineRunner {

    private final UserService userService;

    public InitialDataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        userService.createFistUser();
    }
}
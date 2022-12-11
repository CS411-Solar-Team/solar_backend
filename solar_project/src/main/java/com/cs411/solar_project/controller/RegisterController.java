package com.cs411.solar_project.controller;

import com.cs411.solar_project.model.User;
import com.cs411.solar_project.model.UserRole;
import com.cs411.solar_project.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register/guest")
    public void addGuest(@RequestBody User user) {
        registerService.add(user, UserRole.ROLE_GUEST);
    }

    @PostMapping("/register/admin")
    public void addHost(@RequestBody User user) {
        registerService.add(user, UserRole.ROLE_HOST);
    }
}

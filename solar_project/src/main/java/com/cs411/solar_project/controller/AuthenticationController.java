package com.cs411.solar_project.controller;

import com.cs411.solar_project.model.Token;
import com.cs411.solar_project.model.User;
import com.cs411.solar_project.model.UserRole;
import com.cs411.solar_project.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate/guest")
    public Token authenticateGuest(@RequestBody User user) {
        return authenticationService.authenticate(user, UserRole.ROLE_GUEST);
    }

    @PostMapping("/authenticate/admin")
    public Token authenticateHost(@RequestBody User user) {
        return authenticationService.authenticate(user, UserRole.ROLE_HOST);
    }

}
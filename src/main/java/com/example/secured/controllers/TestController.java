package com.example.secured.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @Secured({"ROLE_USER", "ROLE_MODERATOR", "ROLE_ADMIN"})
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @Secured("ROLE_MODERATOR")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String adminAccess() {
        return "Admin Board.";
    }
}

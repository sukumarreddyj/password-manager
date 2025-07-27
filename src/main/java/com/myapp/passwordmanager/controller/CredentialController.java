package com.myapp.passwordmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.passwordmanager.model.Credential;
import com.myapp.passwordmanager.service.PasswordService;

@RestController
@RequestMapping("/api/credentials")
public class CredentialController {

    private final PasswordService passwordService;

    public CredentialController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping
    public String addCredential(@RequestBody Credential credential) {
        passwordService.addCredential(credential);
        return "Credential saved successfully.";
    }

    @GetMapping
    public List<Credential> viewCredentials() {
        return passwordService.viewCredentials();
    }

    @GetMapping("/generate")
    public String generatePassword(@RequestParam(defaultValue = "12") int length) {
        return passwordService.generatePassword(length);
    }
}

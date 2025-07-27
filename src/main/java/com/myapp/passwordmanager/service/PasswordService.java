package com.myapp.passwordmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.passwordmanager.model.Credential;
import com.myapp.passwordmanager.util.PasswordGenerator;

@Service
public class PasswordService {
    private final FileStorageService storageService;
    private final List<Credential> credentials;

    public PasswordService(FileStorageService storageService) {
        this.storageService = storageService;
        this.credentials = new ArrayList<>(storageService.load());
    }

    public void addCredential(Credential credential) {
        credentials.add(credential);
        storageService.save(credentials);
    }

    public List<Credential> viewCredentials() {
        return credentials;
    }

    public String generatePassword(int length) {
        return PasswordGenerator.generate(length);
    }
}

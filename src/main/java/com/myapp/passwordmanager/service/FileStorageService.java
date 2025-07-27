package com.myapp.passwordmanager.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.passwordmanager.model.Credential;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileStorageService {
    private static final String FILE = "vault.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private final EncryptionService encryptionService = new EncryptionService();

    public void save(List<Credential> credentials) {
        try {
            String json = mapper.writeValueAsString(credentials);
            String encrypted = encryptionService.encrypt(json);
            Files.writeString(new File(FILE).toPath(), encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Credential> load() {
        try {
            File file = new File(FILE);
            if (!file.exists()) return new ArrayList<>();
            String encrypted = Files.readString(file.toPath());
            String json = encryptionService.decrypt(encrypted);
            return mapper.readValue(json, new TypeReference<>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

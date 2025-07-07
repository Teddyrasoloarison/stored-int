package com.example.demo.endpoint.rest.controller;

import com.example.demo.service.StoredIntService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class StoredIntController {
    private final StoredIntService storedIntService;

    public StoredIntController(StoredIntService storedIntService) {
        this.storedIntService = storedIntService;
    }

    @GetMapping("/stored-int")
    public Map<String, Integer> getStoredInt() throws IOException {
        int value = storedIntService.getOrCreatedStoredInt();
        return Map.of("stored_int", value);
    }
}

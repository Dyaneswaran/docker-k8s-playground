package com.playground.backend.controller;

import com.playground.backend.model.StatusMessage;
import com.playground.backend.repository.StatusMessageRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class HealthController {
    private final StatusMessageRepository statusMessageRepository;

    public HealthController(StatusMessageRepository statusMessageRepository) {
        this.statusMessageRepository = statusMessageRepository;
    }

    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }

    @GetMapping("/api/message")
    public Map<String, String> message() {
        if (statusMessageRepository.count() == 0) {
            statusMessageRepository.save(new StatusMessage("Hello from PostgreSQL-backed Spring Boot backend"));
        }

        StatusMessage statusMessage = statusMessageRepository.findAll().get(0);
        return Map.of("message", statusMessage.getMessage());
    }
}
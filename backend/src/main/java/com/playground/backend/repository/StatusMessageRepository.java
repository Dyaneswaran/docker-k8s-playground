package com.playground.backend.repository;

import com.playground.backend.model.StatusMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusMessageRepository extends JpaRepository<StatusMessage, Long> {
}
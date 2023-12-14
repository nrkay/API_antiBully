package com.example.antiBully.repository;

import com.example.antiBully.model.PsychologyDetail;
import com.example.antiBully.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

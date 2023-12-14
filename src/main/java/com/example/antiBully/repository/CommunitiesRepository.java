package com.example.antiBully.repository;

import com.example.antiBully.model.Communities;
import com.example.antiBully.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommunitiesRepository extends JpaRepository<Communities, UUID> {
}

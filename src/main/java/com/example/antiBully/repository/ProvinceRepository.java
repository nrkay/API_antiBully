package com.example.antiBully.repository;

import com.example.antiBully.model.Province;
import com.example.antiBully.model.PsychologyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProvinceRepository extends JpaRepository<Province, UUID> {
}

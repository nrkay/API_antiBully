package com.example.antiBully.repository;

import com.example.antiBully.model.Article;
import com.example.antiBully.model.PsychologyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
}

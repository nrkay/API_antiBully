package com.example.antiBully.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Builder
@Validated
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "articles")
@SQLDelete(sql = "UPDATE articles SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Article extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Content is mandatory")
    private String content;
    private String image;

    @NotBlank(message = "Author is mandatory")
    private String author;
}

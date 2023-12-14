package com.example.antiBully.dto.article;

import lombok.*;

import java.util.UUID;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseArticle {
    private String title;
    private String content;
    private String image;
    private String author;
}

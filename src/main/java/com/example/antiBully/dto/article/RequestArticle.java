package com.example.antiBully.dto.article;

import lombok.*;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestArticle {
    private String title;
    private String content;
    private String image;
    private String author;
}

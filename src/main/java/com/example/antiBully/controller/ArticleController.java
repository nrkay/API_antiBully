package com.example.antiBully.controller;

import com.example.antiBully.dto.article.RequestArticle;
import com.example.antiBully.dto.article.ResponseArticle;
import com.example.antiBully.dto.responData.ResponseHandler;
import com.example.antiBully.model.Article;
import com.example.antiBully.service.ArticleService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@Validated
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ModelMapper modelMapper;

    //find Aryicle By Id
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id){
        ResponseArticle response = modelMapper.map(articleService.finfById(id), ResponseArticle.class);
        return ResponseHandler.generateResponse("data successfully found",
                HttpStatus.OK,
                response);
    }

    //add article
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Article article){
        ResponseArticle response = articleService.addArticle(article);
        return ResponseHandler.generateResponse("Successfuly Create Data", HttpStatus.OK, response);
    }

    //delete article
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable UUID id){
        articleService.deleteData(id);
        return ResponseEntity.ok("Delete data is successfuly");
    }

    //edit article
    @PutMapping("/{id}")
    public ResponseEntity<Object> editData(@PathVariable("id") UUID id, @RequestBody RequestArticle requestArticle){
        ResponseArticle response = articleService.editArticle(id, requestArticle);
        return ResponseHandler.generateResponse("Successfuly Edit Data", HttpStatus.OK, response);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> editArticle(@PathVariable("id") UUID id,
//                                              @RequestBody Article article){
//        ResponseArticle response = articleService.editArticle(id,article);
//        return ResponseHandler.responsePost(HttpStatus.OK, response);
//
//    }

}

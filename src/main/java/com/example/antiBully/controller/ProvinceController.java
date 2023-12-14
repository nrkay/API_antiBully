package com.example.antiBully.controller;

import com.example.antiBully.dto.Province.RequestProvince;
import com.example.antiBully.dto.Province.ResponseProvince;
import com.example.antiBully.dto.article.RequestArticle;
import com.example.antiBully.dto.responData.ResponseHandler;
import com.example.antiBully.model.Article;
import com.example.antiBully.model.Province;
import com.example.antiBully.service.ProvinceService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@Validated
@RequestMapping("/api/province")
public class ProvinceController {
    @Autowired
    private ProvinceService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getArticle(@PathVariable UUID id){
        Optional<Province> response = Optional.ofNullable(service.findById(id));
        return ResponseHandler.generateResponse("Successfult Get Data", HttpStatus.OK,
                modelMapper.map(response.get(), ResponseProvince.class));
    }

    @PostMapping("/")
    public ResponseEntity<Object> addData(@RequestBody @Valid RequestProvince request){
        return ResponseHandler.generateResponse("Successfuly Create Data",
                HttpStatus.OK,
                service.addProvince(request));
    }

}

package com.example.antiBully.service;

import com.example.antiBully.advice.exception.DataNotFoundException;
import com.example.antiBully.dto.article.RequestArticle;
import com.example.antiBully.dto.article.ResponseArticle;
import com.example.antiBully.model.Article;
import com.example.antiBully.repository.ArticleRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ModelMapper modelMapper;

    //finf by id
    public Article finfById(UUID id){
        return articleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Data is Not Found"));
    }
    //add article
    public ResponseArticle addArticle(@Valid Article article){
        Article response = articleRepository.save(article);
        return modelMapper.map(response, ResponseArticle.class);
    }

    //edit article
    public ResponseArticle editArticle(UUID id, RequestArticle request){
        var dataExist = finfById(id);
        dataExist.setImage(request.getImage());
        dataExist.setAuthor(request.getAuthor());
        dataExist.setContent(request.getContent());
        dataExist.setTitle(request.getTitle());
        Article dataUpdate = articleRepository.save(dataExist);
        return modelMapper.map(dataUpdate, ResponseArticle.class);
    }

//        Optional<Article> findArticle = articleRepository.findById(id);
//        if (Objects.isNull(findArticle)){
//            throw new DataNotFoundException("Article is Not Found");
//        } else {
//            Article articleUpd = findArticle.get();
//            articleUpd.setTitle(req.getTitle());
//            articleUpd.setAuthor(req.getAuthor());
//            articleUpd.setContent(req.getContent());
//            articleUpd.setImage(req.getImage());
//            Article articleUpdate = articleRepository.save(articleUpd);
//            return modelMapper.map(articleUpdate, ResponseArticle.class);
//
//        }
    //delete article
    public void deleteData(UUID id){
        var dataExist = finfById(id);
        if (dataExist != null){
            articleRepository.delete(dataExist);
        }
    }


}

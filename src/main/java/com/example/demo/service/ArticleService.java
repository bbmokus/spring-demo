package com.example.demo.service;

import com.example.demo.Article;
import com.example.demo.persistence.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    final ArticleRepository repository;

    public ArticleService(@Autowired ArticleRepository repository) {
        this.repository = repository;
    }

    public Optional<Article> getArticle(Long id) {
        return repository.findById(id);
    }

}

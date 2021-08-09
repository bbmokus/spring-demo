package com.example.demo.api;

import com.example.demo.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("articles")
public class ArticleController {

    final ArticleService service;

    public ArticleController(@Autowired ArticleService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Article getArticle(@PathVariable Long id) {
        return service.getArticle(id).orElseThrow(NotFoundException::new);
    }


}

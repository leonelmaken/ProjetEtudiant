package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Article")
public class ArticleController {

	final
    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createArticle(@RequestBody Article article){
        return articleService.createArticle(article);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateArticle(@RequestBody Article article, @PathVariable Long id){
        return articleService.updateArticle(article, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        return articleService.deleteArticle(id);
    }

    @GetMapping(path = "/read")
    public List<Article> readAllArticle(){
        return articleService.getAll();
    }

    @GetMapping(path = "/read/{id}")
    public Article readArticle(@PathVariable Long id){
        return articleService.getArticle(id);
    }

    @GetMapping("/read/name/{name}")
    public List<Article> getArticleByAuteur(@PathVariable String name) {
        return articleService.findByNameAuteur(name);
    }

    @GetMapping("/read/theme/{theme}")
    public List<Article> getArticleBytheme(@PathVariable String theme) {
        return articleService.findByTheme(theme);
    }

    @GetMapping("/read/desc/{desc}")
    public List<Article> getArticleByDescription(@PathVariable String desc) {
        return articleService.findByDescription(desc);
    }

}

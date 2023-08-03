package com.mono.pjdepartement.service;

import com.mono.pjdepartement.entity.app.Article;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticleService {
	ResponseEntity<String> createArticle(Article article);
	ResponseEntity<String> updateArticle(Article article, Long id);
	List<Article> getAll();
	Article getArticle(Long id);
	String deleteArticle(Long id);
	List<Article> findByTheme(String theme);
	List<Article> findByNameAuteur(String nameAuteur);
    List<Article> findByDescription(String description);
}

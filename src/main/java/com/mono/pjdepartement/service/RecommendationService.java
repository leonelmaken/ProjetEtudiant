package com.mono.pjdepartement.service;

import java.util.List;

import com.mono.pjdepartement.entity.app.Recommendation;
import org.springframework.http.ResponseEntity;

public interface RecommendationService {

	ResponseEntity<String> create(Recommendation recommendation);
    ResponseEntity<String> update(Recommendation recommendation, Long id);
    List<Recommendation> getAll();
    Recommendation getRecommendation(Long id);
    String deleteRecommendztion(Long id);
}

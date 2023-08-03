package com.mono.pjdepartement.controller;

import java.util.List;

import com.mono.pjdepartement.entity.app.Recommendation;
import com.mono.pjdepartement.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/Recommendation")
public class RecommendationController {

	final
    RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createRecommendation(@RequestBody Recommendation recommendation){
        return recommendationService.create(recommendation);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateRecommendation(@RequestBody Recommendation recommendation, @PathVariable Long id){
        return recommendationService.update(recommendation, id);
    }

    @GetMapping(path = "/read")
    public List<Recommendation> readAllRecommendation(){
        return recommendationService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteRecommendation(@PathVariable Long id){
        return recommendationService.deleteRecommendztion(id);
    }

}

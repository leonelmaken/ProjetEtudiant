package com.mono.pjdepartement.service.implement;

import java.util.List;
import java.util.Optional;

import com.mono.pjdepartement.entity.app.Recommendation;
import com.mono.pjdepartement.entity.repository.RecommendationRepository;
import com.mono.pjdepartement.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {
	
	@Autowired
	RecommendationRepository recommendationRepository;

	@Override
	public ResponseEntity<String> create(Recommendation recommendation) {
		try {
            if (recommendation.getDescriptif() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer un descriptif",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
           
            recommendationRepository.save(recommendation);
            return new ResponseEntity<>(
                    "Votre recommendation a été enregistrrer " + recommendationRepository.save(recommendation),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
					"An exception has occured: "+e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	@Override
	public ResponseEntity<String> update(Recommendation recommentation, Long id) {
		Optional<Recommendation> use = recommendationRepository.findById(id);
        if(use.isEmpty()) {
            return new ResponseEntity<>(
                    "Student not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        }
        if (recommentation.getDescriptif()!= null || !use.get().getDescriptif().equals(recommentation.getDescriptif())) {
            use.get().setDescriptif(recommentation.getDescriptif());
        }
        recommendationRepository.save(recommentation);
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
	}

	@Override
	public List<Recommendation> getAll() {
		return recommendationRepository.findAll();
	}

	@Override
	public Recommendation getRecommendation(Long id) {
		if (recommendationRepository.findById(id).isPresent())
            return recommendationRepository.findById(id).get();
        else return null;
	}

	@Override
	public String deleteRecommendztion(Long id) {
		recommendationRepository.deleteById(id);
        return "la recommendation a été supprimé";
	}

}

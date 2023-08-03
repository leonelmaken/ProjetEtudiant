package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long>{

}

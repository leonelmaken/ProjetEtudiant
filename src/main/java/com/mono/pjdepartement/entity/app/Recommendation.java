package com.mono.pjdepartement.entity.app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Recommender")
public class Recommendation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecommendation;

    @Column(length = 200)
    private String descriptif;

	public Recommendation() {
		super();
	}

	public Recommendation(String descriptif) {
		super();
		this.descriptif = descriptif;
	}

	public Long getIdRecommendation() {
		return idRecommendation;
	}

	public void setIdRecommendation(Long idRecommendation) {
		this.idRecommendation = idRecommendation;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	@Override
	public String toString() {
		return "Recommendation [idRecommendation=" + idRecommendation + ", descriptif=" + descriptif + "]";
	}
}

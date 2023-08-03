package com.mono.pjdepartement.service;

import com.mono.pjdepartement.entity.app.Projet;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjetService {
	ResponseEntity<String> create(Projet projet);
	ResponseEntity<String> update(Projet projet, Long id);
	List<Projet> getAll();
	Projet getProjet(Long id);
	String deleteProjet(Long id);
	List<Projet> findByTheme(String theme);
}

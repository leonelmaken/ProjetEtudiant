package com.mono.pjdepartement.service;

import java.util.List;

import com.mono.pjdepartement.entity.app.Emploi;
import org.springframework.http.ResponseEntity;

public interface EmploiService {
	ResponseEntity<String> create(Emploi emploie, Long idE);
	ResponseEntity<String> update(Emploi emploie, Long id);
	List<Emploi> getAll();
	Emploi getEmploi(Long id);
	String delete(Long id);
	List<Emploi> getByPeriode(String periode);
	List<Emploi> getByCompetences(String competences);
	List<Emploi> getByDescription(String description);
	List<Emploi> getByPoste(String poste);
	List<Emploi> getBySecteur(String secteur);
}

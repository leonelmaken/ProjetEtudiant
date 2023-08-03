package com.mono.pjdepartement.service;

import com.mono.pjdepartement.entity.app.Offre;

import java.util.List;

public interface OffreService {
	List<Offre> getAll();
	Offre getOffre(Long id);
	String delete(Long id);
	List<Offre> getByPeriode(String periode);
	List<Offre> getByCompetences(String competences);
	List<Offre> getByDescription(String description);
	List<Offre> getByPoste(String poste);
}

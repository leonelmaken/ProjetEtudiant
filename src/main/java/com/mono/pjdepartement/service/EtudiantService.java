package com.mono.pjdepartement.service;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import com.mono.pjdepartement.entity.metier.Etudiant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EtudiantService {
	ResponseEntity<String> create(Etudiant etudiant);
	ResponseEntity<String> update(Etudiant etudiant, Long id);
	List<Etudiant> getAll();
	Etudiant getEtudiant(Long id);
	String delete(Long id);
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByPrenom(String prenom);
	Etudiant findByMatricule(String matricule);
	List<Etudiant> findByCompetence(String competence);
	List<Etudiant> findByNiveau(String niveau);
	ResponseEntity<String> addArticle(Article article, Long id);
	List<Article> getAllArticles(Long id);
	ResponseEntity<String> addProjet(Projet projet, Long id);
	List<Projet> getAllProjects(Long id);
	ResponseEntity<String> addCompetence(Long id, String comp);
}

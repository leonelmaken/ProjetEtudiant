package com.mono.pjdepartement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import com.mono.pjdepartement.entity.metier.Enseignant;

public interface EnseignantService {
    ResponseEntity<String> create(Enseignant enseignant);
    ResponseEntity<String> update(Enseignant enseignant, Long id);
    Enseignant getEnseignant(Long id);
    List<Enseignant> getAll();
    String delete(Long id);
    List<Enseignant> getByNom(String nom);
    List<Enseignant> getByPrenom(String prenom);
    Enseignant getByMatricule(String matricule);
    List<Enseignant> getBySpeciality(String specialite);
    List<Enseignant> getByCompetences(String competences);
    ResponseEntity<String> addArticle(Article article, Long id);
    List<Article> getAllArticles(Long id);
    ResponseEntity<String> addProjet(Projet projet, Long id);
    List<Projet> getAllProjects(Long id);
    ResponseEntity<String> addCompetence(Long id, String comp);
}

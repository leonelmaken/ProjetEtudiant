package com.mono.pjdepartement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mono.pjdepartement.entity.metier.Entreprise;
import com.mono.pjdepartement.entity.metier.Etudiant;


public interface EntrepriseService {
    ResponseEntity<String> create(Entreprise entreprise);
//    ResponseEntity<String> create(Entreprise entreprise, MultipartFile photo) throws IOException;
    ResponseEntity<String> update(Entreprise entreprise, Long id);
    Entreprise getEnterprise(Long id);
    List<Entreprise> getAll();
    ResponseEntity<String> delete(Long id);
    List<Entreprise> findByName(String name);
    List<Entreprise> findByLocation(String name);
    List<Entreprise> findByWebSite(String webSite);
    ResponseEntity<String> addParraine(Etudiant etudiant, Long id);
    List<Etudiant> getAllParraines(Long id);
    ResponseEntity<String> addStagiaire(Etudiant etudiant, Long id);
    List<Etudiant> getAllStagiaires(Long id);
}

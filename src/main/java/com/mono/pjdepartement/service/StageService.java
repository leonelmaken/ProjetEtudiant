package com.mono.pjdepartement.service;

import java.util.List;

import com.mono.pjdepartement.entity.app.Stage;
import org.springframework.http.ResponseEntity;

public interface StageService {
    ResponseEntity<String> create(Stage stage, Long idE);
    ResponseEntity<String> update(Stage stage, Long id);
    List<Stage> getAll();
    Stage getStage(Long id);
    String delete(Long id);
    List<Stage> getByPeriode(String periode);
    List<Stage> getByCompetences(String competences);
    List<Stage> getByDescription(String description);
    List<Stage> getByPoste(String poste);
}

package com.mono.pjdepartement.controller;

import java.util.List;

import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.entity.metier.Etudiant;
import com.mono.pjdepartement.service.EncadrementService;
import com.mono.pjdepartement.entity.app.Encadrement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Encadrement")
public class EncadrementController {
    
    private final EncadrementService encadrementService;

    @Autowired
    public EncadrementController(EncadrementService encadrementService) {
        this.encadrementService = encadrementService;
    }

    @PostMapping("/assign")  // Endpoint pour assigner un enseignant à un étudiant
    public ResponseEntity<Void> assignerEnseignantEtudiant(@RequestBody Encadrement encadrement) {
        Enseignant enseignant = encadrementService.getEnseignantById(encadrement.getEnseignant().getIdUser());
        Etudiant etudiant = encadrementService.getEtudiantById(encadrement.getEtudiant().getIdUser());
        encadrementService.assignerEnseignantEtudiant(enseignant, etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/read/{idEnseignant}/etudiants")  // Endpoint pour récupérer la liste des étudiants encadrés par un enseignant
    public ResponseEntity<List<Etudiant>> getEtudiantsEncadres(@PathVariable Long idEnseignant) {
        Enseignant enseignant = encadrementService.getEnseignantById(idEnseignant);
        List<Etudiant> etudiantsEncadres = encadrementService.getEtudiantsEncadres(enseignant);
        return ResponseEntity.ok(etudiantsEncadres);
    }

    @GetMapping("/read/{idEtudiant}/enseignants")  // Endpoint pour récupérer la liste des enseignants encadrant un étudiant
    public ResponseEntity<List<Enseignant>> getEnseignantsEncadrant(@PathVariable Long idEtudiant) {
        Etudiant etudiant = encadrementService.getEtudiantById(idEtudiant);
        List<Enseignant> enseignantsEncadrants = encadrementService.getEnseignantsEncadrant(etudiant);
        return ResponseEntity.ok(enseignantsEncadrants);
    }

    @PutMapping("/update")  // Endpoint pour modifier un encadrement existant
    public ResponseEntity<Void> modifierEncadrement(@RequestBody Encadrement encadrement) {
        encadrementService.modifierEncadrement(encadrement);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")  // Endpoint pour supprimer un encadrement existant
    public ResponseEntity<Void> supprimerEncadrement(@PathVariable Long id) {
        Encadrement encadrement = encadrementService.getEncadrementById(id);
        encadrementService.supprimerEncadrement(encadrement);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/read")  // Endpoint pour récupérer la liste de tous les encadrements existants
    public ResponseEntity<List<Encadrement>> getEncadrements() {
        List<Encadrement> encadrements = encadrementService.getEncadrements();
        return ResponseEntity.ok(encadrements);
    }
	
}

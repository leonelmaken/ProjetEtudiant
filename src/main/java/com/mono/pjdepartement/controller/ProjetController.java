package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Projet;
import com.mono.pjdepartement.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Projet")
public class ProjetController {

	final
    ProjetService projetService;

    @Autowired
    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> creatProjet(@RequestBody Projet projet){
        return projetService.create(projet);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateProjet(@RequestBody Projet projet, @PathVariable Long id){
        return projetService.update(projet, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteProjet(@PathVariable Long id){
        return projetService.deleteProjet(id);
    }

    @GetMapping(path = "/read")
    public List<Projet> readAllProjet(){
        return projetService.getAll();
    }

    @GetMapping("/read/theme/{theme}")
    public List<Projet> getProjetBytheme(@PathVariable String theme) {
        return projetService.findByTheme(theme);
    }

}

package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.metier.Entreprise;
import com.mono.pjdepartement.entity.metier.Etudiant;
import com.mono.pjdepartement.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Entreprise")
public class EntrepriseController {

    final
    EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseService.create(entreprise);
    }
//
//    @PostMapping(path = "/create")
//    public ResponseEntity<String> createEntreprise(@RequestParam("user") String entreprise, @RequestParam("photo") MultipartFile photo) throws Exception {
//        Entreprise enterprise = new ObjectMapper().readValue(entreprise, Entreprise.class);
//        return entrepriseService.create(enterprise, photo);
//    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateEntreprise(@RequestBody Entreprise entreprise, @PathVariable Long id) {
        return entrepriseService.update(entreprise, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteEntreprise(@PathVariable Long id) {
        return entrepriseService.delete(id);
    }

    @GetMapping(path = "/read")
    public List<Entreprise> readAllEntreprise(){
        return entrepriseService.getAll();
    }

    @GetMapping(path = "/read/{id}")
    public Entreprise readEntreprise(@PathVariable Long id){
        return entrepriseService.getEnterprise(id);
    }

    @GetMapping(path = "/read/name/{name}")
    public List<Entreprise> getEntrepriseByName(@PathVariable String name){
        return entrepriseService.findByName(name);
    }

    @GetMapping(path = "/read/locality/{locality}")
    public List<Entreprise> getEntrepriseByLocality(@PathVariable String locality){
        return entrepriseService.findByLocation(locality);
    }

    @PutMapping(path = "/add/{id}/parraine")
    public ResponseEntity<String> addParraine(@RequestBody Etudiant etudiant, @PathVariable Long id){
        return entrepriseService.addParraine(etudiant, id);
    }

    @GetMapping(path = "/read/{id}/parraine")
    public List<Etudiant> readAllParraine(@PathVariable Long id){
        return entrepriseService.getAllParraines(id);
    }

    @PutMapping(path = "/add/{id}/stagiaire")
    public ResponseEntity<String> addStagiaire(@RequestBody Etudiant etudiant, @PathVariable Long id){
        return entrepriseService.addStagiaire(etudiant, id);
    }

    @GetMapping(path = "/read/{id}/stagiaire")
    public List<Etudiant> readAllStagiaire(@PathVariable Long id){
        return entrepriseService.getAllStagiaires(id);
    }

}

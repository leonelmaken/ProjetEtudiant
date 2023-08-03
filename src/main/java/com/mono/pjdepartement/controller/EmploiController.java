package com.mono.pjdepartement.controller;

import java.util.List;

import com.mono.pjdepartement.entity.app.Emploi;
import com.mono.pjdepartement.service.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/Emploi")
public class EmploiController {

	final
    EmploiService offreEmploi;

    @Autowired
    public EmploiController(EmploiService offreEmploi) {
        this.offreEmploi = offreEmploi;
    }

    @PostMapping(path = "/create/{idE}")
    public ResponseEntity<String> createEmploi(@RequestBody Emploi emploi, @PathVariable Long idE){
        return offreEmploi.create(emploi, idE);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateEmploi(@RequestBody Emploi emploi, @PathVariable Long id){
        return offreEmploi.update(emploi, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEmploi(@PathVariable Long id){
        return offreEmploi.delete(id);
    }

    @GetMapping(path = "/read")
    public List<Emploi> readAllEmploi(){
        return offreEmploi.getAll();
    }

    @GetMapping("/read/{id}")
    public Emploi getEmploi(@PathVariable Long id) {
        return offreEmploi.getEmploi(id);
    }

    @GetMapping("/read/poste/{poste}")
    public List<Emploi> getEmploiByPoste(@PathVariable String poste) {
        return offreEmploi.getByPoste(poste);
    }

    @GetMapping("/read/period/{period}")
    public List<Emploi> getEmploiByPeriod(@PathVariable String period) {
        return offreEmploi.getByPeriode(period);
    }

    @GetMapping("/read/comp/{comp}")
    public List<Emploi> getEmploiByCompetences(@PathVariable String comp) {
        return offreEmploi.getByCompetences(comp);
    }

    @GetMapping("/read/desc/{desc}")
    public List<Emploi> getEmploiByDescription(@PathVariable String desc) {
        return offreEmploi.getByDescription(desc);
    }

    @GetMapping("/read/secteur/{secteur}")
    public List<Emploi> getEmploiBySecteur(@PathVariable String secteur) {
        return offreEmploi.getBySecteur(secteur);
    }
}

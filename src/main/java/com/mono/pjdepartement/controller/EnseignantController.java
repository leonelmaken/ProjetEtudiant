package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Enseignant")
public class EnseignantController {
    
    final
    EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

//    //Page d'affichage de tous les enseignants
//    @GetMapping("/")
//    public String home(Model model) {
//        List<Enseignant> listEnseignant = enseignantService.getAll();
//        model.addAttribute("enseignants", listEnseignant);
//        return "accueil";
//    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createEnseignant(@RequestBody Enseignant enseignant){
        return enseignantService.create(enseignant);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable Long id){
        return enseignantService.update(enseignant, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEnseignant(@PathVariable Long id){
        return enseignantService.delete(id);
    }

    @GetMapping(path = "/read")
    public List<Enseignant> readAllEnseignant(){
        return enseignantService.getAll();
    }

    @GetMapping(path = "/read/{id}")
    public Enseignant readEnseignant(@PathVariable Long id){
        return enseignantService.getEnseignant(id);
    }

    @GetMapping("/read/name/{name}")
    public List<Enseignant> getEnseignantByNom(@PathVariable String name) {
        return enseignantService.getByNom(name);
    }

    @GetMapping("/read/surname/{surname}")
    public List<Enseignant> getEnseignantByPrenom(@PathVariable String surname) {
        return enseignantService.getByPrenom(surname);
    }

    @GetMapping("/read/matricule/{mat}")
    public Enseignant getEnseignantByMatricule(@PathVariable String mat) {
        return enseignantService.getByMatricule(mat);
    }

    @GetMapping("/read/comp/{comp}")
    public List<Enseignant> getEnseignantByxpLanguage(@PathVariable String comp) {
        return enseignantService.getByCompetences(comp);
    }

    @GetMapping("/read/special/{special}")
    public List<Enseignant> getEnseignantByLevel(@PathVariable String special) {
        return enseignantService.getBySpeciality(special);
    }

    @PutMapping(path = "/add/{id}")
    public ResponseEntity<String> addCompetence(@PathVariable Long id, @RequestBody String comp) {
        return enseignantService.addCompetence(id, comp);
    }

    @PutMapping(path = "/add/{id}/article")
    public ResponseEntity<String> addArticle(@RequestBody Article article, @PathVariable Long id){
        return enseignantService.addArticle(article, id);
    }

    @GetMapping(path = "/read/{id}/articles")
    public List<Article> readAllArticle(@PathVariable Long id){
        return enseignantService.getAllArticles(id);
    }

    @PutMapping(path = "/add/{id}/project")
    public ResponseEntity<String> addProject(@RequestBody Projet projet, @PathVariable Long id){
        return enseignantService.addProjet(projet, id);
    }

    @GetMapping(path = "/read/{id}/project")
    public List<Projet> readAllProject(@PathVariable Long id){
        return enseignantService.getAllProjects(id);
    }

}

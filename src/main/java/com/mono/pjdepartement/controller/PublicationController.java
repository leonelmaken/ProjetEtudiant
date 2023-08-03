package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Publication;
import com.mono.pjdepartement.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Publication")
public class PublicationController {

    final
    PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createPublication(@RequestBody Publication pub){
        return publicationService.create(pub);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updatePublication(@RequestBody Publication pub, @PathVariable Long id){
        return publicationService.update(pub, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable Long id){
        return publicationService.delete(id);
    }

    @GetMapping(path = "/read")
    public List<Publication> readAllPublication(){
        return publicationService.getAll();
    }

    @GetMapping(path = "/read/{id}")
    public Publication readPublication(@PathVariable Long id){
        return publicationService.getPub(id);
    }

    @GetMapping(path = "/read/desc/{desc}")
    public List<Publication> readPublicationByDescription(@PathVariable String desc){
        return publicationService.getByDescription(desc);
    }

    @GetMapping(path = "/read/title/{title}")
    public List<Publication> readPublicationByTitle(@PathVariable String title){
        return publicationService.getByTitle(title);
    }

}

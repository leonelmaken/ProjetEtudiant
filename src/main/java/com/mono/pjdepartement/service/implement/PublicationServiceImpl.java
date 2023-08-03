package com.mono.pjdepartement.service.implement;

import com.mono.pjdepartement.entity.app.Publication;
import com.mono.pjdepartement.entity.repository.PublicationRepository;
import com.mono.pjdepartement.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    PublicationRepository publicationRepository;

    @Override
    public ResponseEntity<String> create(Publication pub) {
        try {
            if (pub.getTitle() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer un titre",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (pub.getDescription() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer une description",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }

            Publication pubt = publicationRepository.save(pub);
            return new ResponseEntity<>(
                    "Vous avez enregistré un nouveau pub avec succès: " + pubt,
                    HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> update(Publication pub, Long id) {
        Optional<Publication> uses = publicationRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Enterprise not found.",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

        if (pub.getTitle() != null || !uses.get().getTitle().equals(pub.getTitle()))
            uses.get().setTitle(pub.getTitle());

        if (pub.getDescription() != null || !uses.get().getDescription().equals(pub.getDescription()))
            uses.get().setDescription(pub.getDescription());

        if (pub.getImage() != null || !uses.get().getImage().equals(pub.getImage()))
            uses.get().setImage(pub.getImage());

        publicationRepository.saveAndFlush(uses.get());
        return new ResponseEntity<>(
                "Modification reussie: " + pub,
                HttpStatus.OK);
    }

    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication getPub(Long id) {
        if (publicationRepository.findById(id).isPresent())
            return publicationRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<Publication> getByDescription(String description) {
        return publicationRepository.findByDescription(description);
    }

    @Override
    public List<Publication> getByTitle(String title) {
        return publicationRepository.findByTitle(title);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            publicationRepository.deleteById(id);
            return new ResponseEntity<>(
                    "La publication a bien été supprimée.",
                    HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(
                    "An error has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

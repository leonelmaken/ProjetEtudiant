package com.mono.pjdepartement.service;

import com.mono.pjdepartement.entity.app.Publication;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicationService {
    ResponseEntity<String> create(Publication pub);
    ResponseEntity<String> update(Publication pub, Long id);
    ResponseEntity<String> delete(Long id);
    List<Publication> getAll();
    Publication getPub(Long id);
    List<Publication> getByDescription(String description);
    List<Publication> getByTitle(String title);
}

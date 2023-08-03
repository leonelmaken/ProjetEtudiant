package com.mono.pjdepartement.service;

import com.mono.pjdepartement.entity.app.Publication;
import com.mono.pjdepartement.entity.metier.Admin;
import com.mono.pjdepartement.entity.metier.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    ResponseEntity<String> createAdmin(Admin admin);   
    ResponseEntity<String> updateAdmin(Long id, Admin admin);
    String deleteUser(Long id);
    List<User> getAllUser();
    ResponseEntity<String> createPub(Publication pub);
    List<Publication> getAllPub();
    ResponseEntity<String> updatePub(Publication pub, Long id);
    ResponseEntity<String> deletePub(Long id, Boolean bool);
}

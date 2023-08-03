package com.mono.pjdepartement.service.implement;

import com.mono.pjdepartement.entity.app.Publication;
import com.mono.pjdepartement.entity.metier.Admin;
import com.mono.pjdepartement.entity.metier.User;
import com.mono.pjdepartement.entity.repository.AdminRepository;
import com.mono.pjdepartement.service.AdminService;
import com.mono.pjdepartement.service.PublicationService;
import com.mono.pjdepartement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    final
    UserService userService;

    final
    PublicationService publicationService;

    final
    AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(UserService userService, PublicationService publicationService, AdminRepository adminRepository) {
        this.userService = userService;
        this.publicationService = publicationService;
        this.adminRepository = adminRepository;
    }

    @Override
    public ResponseEntity<String> createAdmin(Admin admin) {
        try {
            if (admin.getNom() == null) { // 1
                return new ResponseEntity<>(
                        "Vous devez entrer un nom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (admin.getMail() == null) { // 1
                return new ResponseEntity<>(
                        "Vous devez entrer une adresse mail",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (admin.getPassword() == null) { // 1
                return new ResponseEntity<>(
                        "Vous devez entrer un mdp",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }

            if (admin.getRoles() != "Admin") 
                admin.setRoles("Admin");

			Admin admin2 = adminRepository.save(admin); // 2
            return new ResponseEntity<>(
                    "Vous avez enregistré un nouveau admin avec succès " + admin2,
                    HttpStatus.CREATED);
        }catch(Exception e) { // 3
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<String> updateAdmin(Long id, Admin admin) {
        Optional<Admin> use = adminRepository.findById(id);
        if(use.isEmpty()) {
            return new ResponseEntity<>(
                    "Admin not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        }
        if (admin.getMail() != null || !use.get().getMail().equals(admin.getMail())) {
            use.get().setMail(admin.getMail());
        }
        if (admin.getPassword() != null || !use.get().getPassword().equals(admin.getPassword())) {
            use.get().setPassword(admin.getPassword());
        }

        adminRepository.saveAndFlush(use.get()); // 2
        return new ResponseEntity<>(
                "Modifications reussies" ,
                HttpStatus.OK);
    }

    
    /*
     * 1 - Si bool = false, le user est supprimé.
     * 2 - Sinon on affiche le message de conservation
     * 3 - On capture une quelconque exception et on l'affiche
     */
    @Override
    public String deleteUser(Long id) {
        return userService.delete(id);
    }

    @Override
    public ResponseEntity<String> createPub(Publication pub) {
        return publicationService.create(pub);
    }

    @Override
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @Override
    public List<Publication> getAllPub() {
        return publicationService.getAll();
    }

    @Override
    public ResponseEntity<String> updatePub(Publication pub, Long id) {
        return publicationService.update(pub, id);
    }

    /*
     * 1 - Si bool = false, la publication est supprimé.
     * 2 - Sinon on affiche le message de conservation
     * 3 - On capture une quelconque exception et on l'affiche
     */
    @Override
    public ResponseEntity<String> deletePub(Long id, Boolean bool) {
        try {
            Publication pub = publicationService.getPub(id);
            if (!bool) { // 1
                publicationService.delete(id);
                return new ResponseEntity<>(
                        "Publication supprimée: " + pub,
                        HttpStatus.OK);
            } else // 2
                return new ResponseEntity<>(
                    "Publication conservée: " + pub,
                    HttpStatus.OK);
        } catch (Exception e){ // 3
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

}

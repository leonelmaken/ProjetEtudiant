package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Publication;
import com.mono.pjdepartement.entity.metier.Admin;
import com.mono.pjdepartement.entity.metier.User;
import com.mono.pjdepartement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Admin")
public class AdminController {

    final
    AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(path = "/create/admin")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin, @PathVariable Long id) {
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping(path = "/delete/user/{id}")
    public String deleteUser(@PathVariable Long id){
        return adminService.deleteUser(id);
    }

    @GetMapping(path = "/read/all/user")
    public List<User> getAllUser(){
        return adminService.getAllUser();
    }

    @PostMapping(path = "/create/pub")
    public ResponseEntity<String> createPublication(@RequestBody Publication pub){
        return adminService.createPub(pub);
    }

    @GetMapping(path = "/read/all/pub")
    public List<Publication> getAllPublication(){
        return adminService.getAllPub();
    }

    @PutMapping(path = "/update/pub/{id}")
    public ResponseEntity<String> updatePublication(@RequestBody Publication pub, @PathVariable Long id){
        return adminService.updatePub(pub, id);
    }

    @DeleteMapping(path = "/delete/pub/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable Long id, Boolean bool){
        return adminService.deletePub(id, bool);
    }

}

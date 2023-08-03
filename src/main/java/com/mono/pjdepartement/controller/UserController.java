package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.metier.User;
import com.mono.pjdepartement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/User")
public class UserController {

	final
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping(path = "/delete/{id}")
	public String deleteEtudiant(@PathVariable Long id){
		return userService.delete(id);
	}

	@GetMapping(path = "/read")
	public List<User> readAllUser(){
		return userService.getAll();
	}

	@GetMapping(path = "/read/id/{id}")
	public User readUser(@PathVariable Long id){
		return userService.getUser(id);
	}

	@GetMapping("/read/name/{name}")
	public List<User> getEtudiantByNom(@PathVariable String name) {
		return userService.getByNom(name);
	}

	@GetMapping("/read/numtel/{numTel}")
	public List<User> getUserByNumTel(@PathVariable Long numTel) {
		return userService.getByNumTel(numTel);
	}

	@GetMapping("/read/mail/{mail}")
	public List<User> getEtudiantByMail(@PathVariable String mail) {
		return userService.getByMail(mail);
	}

}

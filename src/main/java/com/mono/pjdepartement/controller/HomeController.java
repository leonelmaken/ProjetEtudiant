/*
 * Copyright (c) 2023. Link's production
 */

package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.metier.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/home")
    public String connexion(@RequestBody User user){
        return "User Authentified";
    }

}

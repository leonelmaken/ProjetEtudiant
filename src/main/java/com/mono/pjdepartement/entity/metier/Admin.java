package com.mono.pjdepartement.entity.metier;

import jakarta.persistence.*;

@Entity(name = "Admin")
@Table(name = "Admin")
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(Long idUser, String nom, Long numTel, String mail, String password, byte[] photo) {
        super(idUser, nom, numTel, mail, password, photo, "Admin");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}

package com.mono.pjdepartement.entity.metier;

import jakarta.persistence.*;


/*
 * C'est la super classe de tous les Utilisateurs.
 * L'annotation Inheritance(strategy = InheritanceType.JOINED) permet de copier les
 * attributs de la super classes User dans ses classes filles.
 */
@Table(name = "User")
@Entity(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(length = 15, nullable = false)
    private Long numTel;

    @Column(length = 100, nullable = false, unique = true)
    private String mail;

    @Column(length = 100, nullable = false)
    private String password;

    @Lob
    @Column(length = 1000)
    private byte[] photo;

    @Column(length = 100)
    private String roles;

    public User() {
        super();
    }

    public User(Long idUser, String nom, Long numTel, String mail, String password, byte[] photo, String roles) {
        this.idUser = idUser;
        this.nom = nom;
        this.numTel = numTel;
        this.mail = mail;
        this.password = password;
        this.photo = photo;
        this.roles = roles;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getNumTel() {
        return numTel;
    }

    public void setNumTel(Long numTel) {
        this.numTel = numTel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}

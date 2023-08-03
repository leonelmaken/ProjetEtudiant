package com.mono.pjdepartement.entity.metier;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Entreprise")
@Table(name = "Entreprise")
public class Entreprise extends User {

    @Column(length = 50, nullable = false)
    private Long contributeNumber;

    @Column(length = 50, nullable = false)
    private String location;

    @Column(length = 100)
    private String webSite;

//    @DateTimeFormat(pattern="dd//MM/yyyy")
    @Column(nullable = false)
    private Date creationDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etudiant> parraines = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etudiant> stagiaires = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etudiant> employes = new ArrayList<>();

    public Entreprise() {
        super();
    }

    public Entreprise(Long idUser, String nom, Long numTel, String mail, String password, byte[] photo, Long contributeNumber, String location, String webSite, Date creationDate) {
        super(idUser, nom, numTel, mail, password, photo, "Entreprise");
        this.contributeNumber = contributeNumber;
        this.location = location;
        this.webSite = webSite;
        this.creationDate = creationDate;
    }

    public Long getContributeNumber() {
        return contributeNumber;
    }

    public void setContributeNumber(Long contributeNumber) {
        this.contributeNumber = contributeNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Etudiant> getParraines() {
        return parraines;
    }

    public void setParraines(List<Etudiant> parraines) {
        this.parraines = parraines;
    }

    public List<Etudiant> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Etudiant> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public List<Etudiant> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Etudiant> employes) {
        this.employes = employes;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "contributeNumber=" + contributeNumber +
                ", location='" + location + '\'' +
                ", webSite='" + webSite + '\'' +
                ", creationDate=" + creationDate +
                ", parraines=" + parraines +
                ", employes=" + employes +
                ", stagiaires=" + stagiaires +
                "} " + super.toString();
    }

}

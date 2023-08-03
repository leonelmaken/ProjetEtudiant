package com.mono.pjdepartement.entity.metier;

import com.mono.pjdepartement.entity.Worker;
import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Etudiant")
@Table(name = "Etudiant")
public class Etudiant extends User implements Worker {

    @Column(length = 20, nullable = false)
    private String matricule;

    @Column(length = 100)   
    private String prenom;

    @Column(length = 7, nullable = false)
    private String niveau;

    @Column
    private String competence;

    @OneToMany(cascade = CascadeType.ALL)
    List<Projet> projects = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Article> articles = new ArrayList<>();

    public Etudiant() {
        super();
    }

    public Etudiant(Long idUser, String nom, Long numTel, String mail, String password, byte[] photo, String matricule, String prenom, String niveau, String competence) {
        super(idUser, nom, numTel, mail, password, photo, "Etudiant");
        this.matricule = matricule;
        this.prenom = prenom;
        this.niveau = niveau;
        this.competence = competence;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public List<Projet> getProjects() {
        return projects;
    }

    public void setProjects(List<Projet> projects) {
        this.projects = projects;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "matricule='" + matricule + '\'' +
                ", prenom='" + prenom + '\'' +
                ", niveau='" + niveau + '\'' +
                ", competence='" + competence + '\'' +
                ", projects=" + projects +
                ", articles=" + articles +
                "} " + super.toString();
    }
}
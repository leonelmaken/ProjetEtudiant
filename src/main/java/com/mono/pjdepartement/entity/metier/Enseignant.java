package com.mono.pjdepartement.entity.metier;

import com.mono.pjdepartement.entity.Worker;
import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Enseignant")
@Table(name = "Enseignant")
public class Enseignant extends User implements Worker {

    @Column(length = 20, nullable = false)
    private String matricule;

    @Column(length = 100)
    private String prenom;

    @Column(length = 3, nullable = false)
    private String grade;

    @Column(length = 50, nullable = false)
    private String specialite;

    @Column(nullable = false)
    private String competences;

    @OneToMany(cascade = CascadeType.ALL)
    List<Projet> projects = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Article> articles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etudiant> encadrees = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etudiant> recommandes = new ArrayList<>();

    public Enseignant() {
        super();
    }

    public Enseignant(Long idUser, String nom, Long numTel, String mail, String password, byte[] photo, String matricule, String prenom, String grade, String specialite, String competences) {
        super(idUser, nom, numTel, mail, password, photo, "Enseignant");
        this.matricule = matricule;
        this.prenom = prenom;
        this.grade = grade;
        this.specialite = specialite;
        this.competences = competences;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public List<Etudiant> getEncadrees() {
        return encadrees;
    }

    public void setEncadrees(List<Etudiant> encadrees) {
        this.encadrees = encadrees;
    }

    public List<Etudiant> getRecommandes() {
        return recommandes;
    }

    public void setRecommandes(List<Etudiant> recommandes) {
        this.recommandes = recommandes;
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
        return "Enseignant{" +
                "matricule='" + matricule + '\'' +
                ", prenom='" + prenom + '\'' +
                ", grade='" + grade + '\'' +
                ", specialite='" + specialite + '\'' +
                ", competences='" + competences + '\'' +
                ", projects=" + projects +
                ", articles=" + articles +
                ", encadrees=" + encadrees +
                ", recommandes=" + recommandes +
                "} " + super.toString();
    }
}

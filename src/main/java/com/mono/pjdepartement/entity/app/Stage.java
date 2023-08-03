package com.mono.pjdepartement.entity.app;

import com.mono.pjdepartement.entity.metier.Entreprise;
import com.mono.pjdepartement.entity.metier.Etudiant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name="Stage")
@Table(name="Stage")
public class Stage extends  Offre {

	@OneToOne(cascade = CascadeType.ALL)
	private Entreprise employeur;

	@OneToOne(cascade = CascadeType.ALL)
	private Etudiant employe;

	public Stage() {
		super();
	}

	public Stage(String poste, String description, String periode, String competences, Boolean etat, String type, Entreprise employeur) {
		super(poste, description, periode, competences, etat, "Stage");
		this.employeur = employeur;
	}

	public Stage(String poste, String description, String periode, String competences, Boolean etat, String type, Entreprise employeur, Etudiant employe) {
		super(poste, description, periode, competences, etat, "Stage");
		this.employeur = employeur;
		this.employe = employe;
	}

	public Entreprise getEmployeur() {
		return employeur;
	}

	public void setEmployeur(Entreprise employeur) {
		this.employeur = employeur;
	}

	public Etudiant getEmploye() {
		return employe;
	}

	public void setEmploye(Etudiant employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Stage{" +
				"employeur=" + employeur +
				", employe=" + employe +
				"} " + super.toString();
	}
}

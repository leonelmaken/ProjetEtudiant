package com.mono.pjdepartement.entity.app;

import com.mono.pjdepartement.entity.metier.Entreprise;
import com.mono.pjdepartement.entity.metier.Etudiant;
import jakarta.persistence.*;

@Entity(name="Emploi")
@Table(name="Emploi")
public class Emploi extends Offre {

	@Column(length = 50)
	private String secteur;

	@OneToOne(cascade = CascadeType.ALL)
	private Entreprise employeur;

	@OneToOne(cascade = CascadeType.ALL)
	private Etudiant employe;

	public Emploi() {
		super();
	}

	public Emploi(String poste, String description, String periode, String competences, Boolean etat, String type, String secteur, Entreprise employeur) {
		super(poste, description, periode, competences, etat, "Emploi");
		this.secteur = secteur;
		this.employeur = employeur;
	}

	public Emploi(String poste, String description, String periode, String competences, Boolean etat, String type, String secteur, Entreprise employeur, Etudiant employe) {
		super(poste, description, periode, competences, etat, "Emploi");
		this.secteur = secteur;
		this.employeur = employeur;
		this.employe = employe;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
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
		return "Emploi{" +
				"secteur='" + secteur + '\'' +
				", employeur=" + employeur +
				", employe=" + employe +
				"} " + super.toString();
	}
}

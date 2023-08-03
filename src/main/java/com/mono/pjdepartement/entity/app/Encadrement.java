package com.mono.pjdepartement.entity.app;

import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.entity.metier.Etudiant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "Encadrement")
@Table(name = "Encadrement")
public class Encadrement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEncadrement;

	@ManyToOne
	@MapsId("idEtudiant")
	@JoinColumn(name = "etudiant_id")
	private Etudiant etudiant;

	@ManyToOne
	@MapsId("idEnseignant")
	@JoinColumn(name = "enseignant_id")
	private Enseignant enseignant;

	public Encadrement() {
		super();
	}

	public Encadrement(Enseignant enseignant,Etudiant etudiant) {
		super();
		this.etudiant = etudiant;
		this.enseignant = enseignant;
	}

	public Long getIdEncadrement() {
		return idEncadrement;
	}
	public void setIdEncadrement(Long idEncadrement) {
		this.idEncadrement = idEncadrement;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@Override
	public String toString() {
		return "Encadrement [idEncadrement = " + idEncadrement + ", etudiant=" + etudiant + ", enseignant=" + enseignant
				+ "]";
	}
}

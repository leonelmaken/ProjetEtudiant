package com.mono.pjdepartement.service;

import java.util.List;

import com.mono.pjdepartement.entity.app.Encadrement;
import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.entity.metier.Etudiant;

public interface EncadrementService {

	void modifierEncadrement(Encadrement encadrement);
	List<Enseignant> getEnseignantsEncadrant(Etudiant etudiant);
	List<Etudiant> getEtudiantsEncadres(Enseignant enseignant);
	void assignerEnseignantEtudiant(Enseignant enseignant, Etudiant etudiant);
	void supprimerEncadrement(Encadrement encadrement);
	List<Encadrement> getEncadrements();
	Etudiant getEtudiantById(Long idEtudiant);
	Enseignant getEnseignantById(Long idEnseignant);
	Encadrement getEncadrementById(Long idEncadrement);
}

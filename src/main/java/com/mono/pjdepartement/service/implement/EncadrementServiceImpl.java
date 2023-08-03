package com.mono.pjdepartement.service.implement;

import java.util.ArrayList;
import java.util.List;

import com.mono.pjdepartement.entity.app.Encadrement;
import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.entity.metier.Etudiant;
import com.mono.pjdepartement.entity.repository.EncadrementRepository;
import com.mono.pjdepartement.entity.repository.EnseignantRepository;
import com.mono.pjdepartement.entity.repository.EtudiantRepository;
import com.mono.pjdepartement.service.EncadrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncadrementServiceImpl implements EncadrementService {
	
	@Autowired
	EncadrementRepository encadrementRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EnseignantRepository enseignantRepository;

	@Override
	public void modifierEncadrement(Encadrement encadrement) {
		encadrementRepository.save(encadrement);
	}

	@Override
	public List<Enseignant> getEnseignantsEncadrant(Etudiant etudiant) {
		List<Encadrement> encadrements = encadrementRepository.findByEtudiant(etudiant);
		List<Enseignant> enseignantsEncadrants = new ArrayList<>();
		for (Encadrement encadrement : encadrements) {
			enseignantsEncadrants.add(encadrement.getEnseignant());
		}
		return enseignantsEncadrants;
	}

	@Override
	public List<Etudiant> getEtudiantsEncadres(Enseignant enseignant) {
		List<Encadrement> encadrements = encadrementRepository.findByEnseignant(enseignant);
	    List<Etudiant> etudiantsEncadres = new ArrayList<>();
	    for (Encadrement encadrement : encadrements) {
	        etudiantsEncadres.add(encadrement.getEtudiant());
	    }
	    return etudiantsEncadres;
	}

	@Override
	public void assignerEnseignantEtudiant(Enseignant enseignant, Etudiant etudiant) {
		Encadrement encadrement = new Encadrement(enseignant, etudiant);
	    encadrementRepository.save(encadrement);
	}

	@Override
	public void supprimerEncadrement(Encadrement encadrement) {
		encadrementRepository.delete(encadrement);
	}

	@Override
	public List<Encadrement> getEncadrements() {
		 return encadrementRepository.findAll();
	}

	@Override
	public Enseignant getEnseignantById(Long idEnseignant) {
		if (enseignantRepository.findById(idEnseignant).isPresent())
            return enseignantRepository.findById(idEnseignant).get();
        else return null;
	}

	@Override
	public Etudiant getEtudiantById(Long idEtudiant) {
		if (etudiantRepository.findById(idEtudiant).isPresent())
			return etudiantRepository.findById(idEtudiant).get();
		else return null;
	}

	@Override
	public Encadrement getEncadrementById(Long idEncadrement) {
		if (encadrementRepository.findById(idEncadrement).isPresent())
            return encadrementRepository.findById(idEncadrement).get();
        else return null;
	}

}

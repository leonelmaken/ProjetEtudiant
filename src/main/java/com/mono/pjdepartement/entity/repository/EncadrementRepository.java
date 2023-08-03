package com.mono.pjdepartement.entity.repository;

import java.util.List;

import com.mono.pjdepartement.entity.app.Encadrement;
import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.entity.metier.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncadrementRepository extends JpaRepository<Encadrement, Long>{

	List<Encadrement> findByEnseignant(Enseignant enseignant);

	List<Encadrement> findByEtudiant(Etudiant etudiant);

}

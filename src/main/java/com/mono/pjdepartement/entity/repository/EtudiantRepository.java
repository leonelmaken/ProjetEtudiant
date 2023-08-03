package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	@Query("select e from Etudiant e where e.nom like %?1%")
	List<Etudiant> findByNom(String nom);

	@Query("select e from Etudiant e where e.prenom like %?1%")
	List<Etudiant> findByPrenom(String prenom);

	@Query("select e from Etudiant e where e.matricule like %?1%")
	Etudiant findByMatricule(String matricule);

	@Query("select e from Etudiant e where e.competence like %?1%")
	List<Etudiant> findByCompetence(String competence);

	@Query("select e from Etudiant e where e.niveau like %?1%")
	List<Etudiant> findByNiveau(String niveau);
}

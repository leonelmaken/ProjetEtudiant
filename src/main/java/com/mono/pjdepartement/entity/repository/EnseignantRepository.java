package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    @Query("select e from Enseignant e where e.nom like %?1%")
    List<Enseignant> findByNom(String nom);

    @Query("select e from Enseignant e where e.prenom like %?1%")
    List<Enseignant> findByPrenom(String prenom);

    @Query("select e from Enseignant e where e.matricule like %?1%")
    Enseignant findByMatricule(String matricule);

    @Query("select e from Enseignant e where e.specialite like %?1%")
    List<Enseignant> findBySpecialite(String specialite);

    @Query("select e from Enseignant e where e.competences like %?1%")
    List<Enseignant> findByCompetences(String competences);
}

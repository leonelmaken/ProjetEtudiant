package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    @Query("select e from Entreprise e where e.nom like %?1%")
    List<Entreprise> findByNom(String name);

    @Query("select e from Entreprise e where e.location like %?1%")
    List<Entreprise> findByLocation(String location);

    @Query("select e from Entreprise e where e.webSite like %?1%")
    List<Entreprise> findByWebSite(String webSite);
}

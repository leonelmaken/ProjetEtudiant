package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>{
    @Query("select p from Projet p where p.theme like %?1%")
    List<Projet> findByTheme(String theme);

    @Query("select p from Projet p where p.description like %?1%")
    List<Projet> findByDescription(String description);
}

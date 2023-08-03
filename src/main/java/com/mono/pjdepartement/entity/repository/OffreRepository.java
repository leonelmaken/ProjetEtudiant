package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Long>{
	@Query("select e from Emploi e where e.poste like %?1%")
	List<Offre> findByPoste(String poste);

	@Query("select e from Emploi e where e.description like %?1%")
	List<Offre> findByDescription(String description);

	@Query("select e from Emploi e where e.periode like %?1%")
	List<Offre> findByPeriode(String periode);

	@Query("select e from Emploi e where e.competences like %?1%")
	List<Offre> findByCompetences(String competences);
}

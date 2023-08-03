package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long>{
	@Query("select e from Stage e where e.poste like %?1%")
	List<Stage> findByPoste(String poste);

	@Query("select e from Stage e where e.description like %?1%")
	List<Stage> findByDescription(String description);

	@Query("select e from Stage e where e.periode like %?1%")
	List<Stage> findByPeriode(String periode);

	@Query("select e from Stage e where e.competences like %?1%")
	List<Stage> findByCompetences(String competences);

}

package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    @Query("select p from Publication p where p.description like %?1%")
    List<Publication> findByDescription(String description);

    @Query("select p from Publication p where p.title like %?1%")
    List<Publication> findByTitle(String title);
}

package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u where u.nom like %?1%")
	List<User> findByNom(String theme);

	@Query("select u from User u where concat(u.numTel, u.numTel) like %?1%")
	List<User> findByNumTel(Long numTel);

	@Query("select u from User u where u.mail like %?1%")
	List<User> findByMail(String mail);

	@Query("select u from User u where u.password like %?1%")
	List<User> findByPassword(String password);
}

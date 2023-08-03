package com.mono.pjdepartement.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mono.pjdepartement.entity.metier.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}

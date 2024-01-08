package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.Entity.CompanyEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

// @Transactional
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{

//	@PersistenceContext
//	private EntityManager em;
//	
//	public CompanyEntity save(CompanyEntity companyEntity) {
//		em.persist(companyEntity);
//		return companyEntity;
//	}
	
}
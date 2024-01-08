package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.Entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{

	// 1번) id로 조회
	public RecruitEntity findById(int id);
	
	// 2번) companyId로 조회
	public List<RecruitEntity> findByCompanyId(int companyId);
	 
	// 3번) position, type으로 조회
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	// 4번) 정규직이거나 연봉이 9000 이상
	public List<RecruitEntity> findByTypeOrSalaryGreaterThan(String type ,int salary);
	
	// 5번)
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 6번)
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);
	
}

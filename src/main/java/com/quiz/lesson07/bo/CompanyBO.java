package com.quiz.lesson07.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.Entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	// jpa
	public CompanyEntity addCompany(String name, String business,
									String scale, int headcount) {

		CompanyEntity company = CompanyEntity.builder()
								.name(name)
								.business(business)
								.scale(scale)
								.headcount(headcount)
								.build();
		
		return companyRepository.save(company);
	}
}

package com.quiz.lesson07.bo;

import java.util.Optional;

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

//		CompanyEntity company = CompanyEntity.builder()
//								.name(name)
//								.business(business)
//								.scale(scale)
//								.headcount(headcount)
//								.build();
		
		return companyRepository.save(CompanyEntity.builder()
									.name(name)
									.business(business)
									.scale(scale)
									.headcount(headcount)
									.build());
	}
	
	// input: id, headcount
	// output: companyEntity
	public CompanyEntity updateHeadcountById(int id, int headcount, String scale) {
		// select
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// update - save
		if (company != null) {
			company = company.toBuilder()
									.headcount(headcount)
									.scale(scale)
									.build();
			company = companyRepository.save(company);
		}
		
		return company;
	}
	
	// input: id
	public void deleteCompanyById(int id) {
		// select
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(s -> companyRepository.delete(s));
	}
	
}

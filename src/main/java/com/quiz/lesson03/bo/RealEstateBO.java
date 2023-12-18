package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	// input: id      output: RealEstate(있거나 또는 null)
	public RealEstate getRealEstateById(int id) {
	
		return realEstateMapper.selectRealEstateById(id);
	}
	
	// input: rentPrice      output: List<RealEstate>([] 또는 채워져있거나)
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice){
		return realEstateMapper.selectRealEstateByRentPrice(rentPrice);
	}
	
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price){
		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}
	
}

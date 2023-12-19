package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// input: area, price     output:List<RealEstate> [] or 채워져있는 리스트 (null일 수 없다.)
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price){
		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}
	
	// input: RealEstate		output: 성공한 행의 개수
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	// input: @Param int realtor_id, String address
	// , int area, String type, int price, int rentPrice
	// output: 성공한 행의 개수
	public int addRealEstateByRealtorId(int realtorId, String address, int area, String type
			, int price, int rentPrice) {
		return realEstateMapper.insertRealEstateByRealtorId(realtorId, address, area, type, price, rentPrice);
	}
}

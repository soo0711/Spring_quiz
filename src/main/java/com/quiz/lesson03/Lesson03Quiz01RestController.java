package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController
@RequestMapping("/lesson03/quiz01")
public class Lesson03Quiz01RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// url: http://localhost:8010/lesson03/quiz01/1
	// url: http://localhost:8010/lesson03/quiz01/1?id=20
	// input: id      output: RealEstate(있거나 또는 null)
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam(value="id", defaultValue ="1") int id) {
		
		return realEstateBO.getRealEstateById(id);
	}
	
	// url: http://localhost:8010/lesson03/quiz01/2
	// url: http://localhost:8010/lesson03/quiz01/2?rent_price=90
	// input: rentPrice      output: List<RealEstate>([] 또는 채워져있거나)
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			@RequestParam(value = "rent_price", defaultValue = "150") int rentPrice){
		return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
	// url: http://localhost:8010/lesson03/quiz01/3
	// url: http://localhost:8010/lesson03/quiz01/3?area=90&price=130000
	// input: area, price     output:List<RealEstate> [] or 채워져있는 리스트 (null일 수 없다.)
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam(value = "area", defaultValue = "50") int area
			,@RequestParam(value="price", defaultValue = "70000") int price){
		return realEstateBO.getRealEstateByAreaPrice(area, price);
	}
		
}

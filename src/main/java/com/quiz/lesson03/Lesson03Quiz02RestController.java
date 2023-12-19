package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController
@RequestMapping("lesson03/quiz02")
public class Lesson03Quiz02RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// url: localhost:8010/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz02_1() {
		RealEstate realestate = new RealEstate();
		realestate.setRealtorId(3);
		realestate.setAddress("푸르지용 리버 303동 1104호");
		realestate.setArea(89);
		realestate.setType("매매");
		realestate.setPrice(100000);
		
		int row = realEstateBO.addRealEstate(realestate);
		
		return "입력 성공: " + row ;
	}
	
	// url: localhost:8010/lesson03/quiz02/2?realtor_id=5
	@RequestMapping("/2")
	public String quiz02_2(
			@RequestParam(value = "realtor_id")int realtorId){

		int row = realEstateBO.addRealEstateByRealtorId(realtorId, "썅떼빌리버 오피스텔 814호"
				,45 , "월세", 100000, 120);
		return "입력 성공: " + row ;
	}
	
}

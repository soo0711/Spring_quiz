package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// url: http://localhost:8080/lesson04/quiz01/add-seller-view
	@RequestMapping("/add-seller-view")
	public String addSellerView(){
		
		return "lesson04/addSeller";
	}
	
	@RequestMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", required = false) Double temperature) {
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "/lesson04/afterAddSeller";
	}
	
	@RequestMapping("/seller-info")
	public String sellerInfo(Model model) {
		Seller seller = sellerBO.getLatestSeller();
		model.addAttribute("result", seller);
		model.addAttribute("title", "판매자 정보");
		
		return "/lesson04/sellerInfo";
	}
}

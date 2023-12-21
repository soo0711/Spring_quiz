package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// 판매자 추가 화면
	// url: http://localhost:8080/lesson04/quiz01/add-seller-view
	@RequestMapping("/add-seller-view")
	public String addSellerView(){
		return "lesson04/addSeller";
	}
	
	// DB insert => 입력 성공 화면 
	// url: http://localhost:8080/lesson04/quiz01/add-seller
	@PostMapping("/add-seller") // post 방식으로만 가능하다
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		// DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "/lesson04/afterAddSeller";
	}
	
	// url: http://localhost:8080/lesson04/quiz01/seller-info
	// url: http://localhost:8080/lesson04/quiz01/seller-info?id=2
	@GetMapping("/seller-info")
	public String sellerInfo(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		Seller seller = null;
		// db select
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		// model에 넣기
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		// 응답 화면
		return "/lesson04/sellerInfo";
	}
}

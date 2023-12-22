package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;

	// 공인중개사 추가 화면
	// http://localhost:8010/lesson04/quiz02/add_realtor_view
	@RequestMapping("/add_realtor_view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// 공인중개사 추가 후 출력
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor
			, Model model) {
		// DB insert
		realtorBO.addRealtor(realtor);
		
		// id 받아오기
		// int id = realtor.getId();
		
		// getId를 파라미터에 바로 받아오기
		// DB select
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		
		// Model에 저장
		model.addAttribute("realtor", latestRealtor);
		model.addAttribute("title", "공인중개사 정보");
		
		// table로 뿌리기
		return "lesson04/afterAddRealtor";
	}
}

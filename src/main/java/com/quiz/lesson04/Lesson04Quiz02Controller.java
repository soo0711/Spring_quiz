package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {

	// 공인중개사 추가 화면
	// http://localhost:8010/lesson04/quiz02/add_realtor_view
	@RequestMapping("/add_realtor_view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// 공인중개사 추가 후 출력
	@RequestMapping("/add-realtor")
	public String addRealtor() {
		// DB insert
		
		// id 받아오기
		
		// DB select
		
		// table로 뿌리기
		return "lesson04/afterAddRealtor";
	}
}

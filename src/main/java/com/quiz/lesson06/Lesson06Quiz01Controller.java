package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 즐겨찾기 입력 화면
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		//insert
		bookmarkBO.addBookmark(name, url);
		
		// ajax로 보내기
		return "성공";
	}
	
	@GetMapping("/bookmark-list")
	public String bookmarkList(
			Model model) {
		
		// select
		List<Bookmark> bookmarkList = bookmarkBO.getBookmark();
		
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
	}
	
}

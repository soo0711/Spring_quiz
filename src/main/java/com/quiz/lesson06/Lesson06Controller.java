package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@Controller
@RequestMapping("/lesson06")
public class Lesson06Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 즐겨찾기 입력 화면
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	
	// 입력 수행 - AJAX 통신 요청 => (응답값 String - 성공이라고 보내기) / 응답값 JSON String
	@ResponseBody
	@PostMapping("/quiz01/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		//insert
		bookmarkBO.addBookmark(name, url);
		
		// "{"code":200, "result:"성공"}"
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		// ajax로 보내기
		return result; // map => JSON String
	}
	
	// 즐겨찾기 목록 화면 
	@GetMapping("/quiz01/bookmark-list")
	public String bookmarkList(
			Model model) {
		
		// select
		List<Bookmark> bookmarkList = bookmarkBO.getBookmark();
		
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
	}
	
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url){
		
		// db select
		boolean isDuplication = bookmarkBO.isDuplicationByUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code",200);
		result.put("is_duplication", isDuplication);
		
		return result;
	}
	
	@ResponseBody
	@DeleteMapping("/deleteBookmark")
	public Map<String, Object> deleteBookmarkById(
			@RequestParam("id") int id){
		
		// 삭제 (rowCount)
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제하는데 실패했습니다.");
		}
		// response
		return result;
	}

}

package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	// input: name, url
	// output: X
	public void addBookmark(String name, String url) {
		bookmarkMapper.addBookmark(name, url);
	}
	
	// input: X
	// output: list
	public List<Bookmark> getBookmark(){
		
		return bookmarkMapper.selectBookmark();
	}
}

package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	// input: name, url
	// output: X
	public void addBookmark(
			@Param("name") String name, 
			@Param("url") String url);

	// input: X
	// output: list
	public List<Bookmark> selectBookmark();
	
	// input: url
	// output: boolean
	public List<Bookmark> selectBookmarkListByUrl(String url);
	
	// input: url, name
	// output: X
	public int deleteBookmarkById(int id);
}


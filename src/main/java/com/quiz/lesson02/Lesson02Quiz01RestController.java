package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController
public class Lesson02Quiz01RestController {

	// field
	@Autowired
	private StoreBO storeBO;
	
	// url: https://localhost:8010/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quix01(){
		return storeBO.getStoreList();
	}
}

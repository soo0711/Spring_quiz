package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreBO storeBO;
	
	@GetMapping("/store-list-view")
	public String storeListView(
			Model model) {
		
		// select
		List<Store> store = storeBO.getStoreList();
		model.addAttribute("storeList", store);
		
		return "store/storeList";
	}
	
	
}

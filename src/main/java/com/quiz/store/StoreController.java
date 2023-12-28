package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;
import com.quiz.store.domain.Review;

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
	
	@GetMapping("/store-review-view")
	public String storeReviewView(
			@RequestParam("storeId") int storeId,
			@RequestParam("storeName") String storeName,
			Model model) {
		
		// select
		List<Review> review = storeBO.getStoreListById(storeId);
		
		// model
		model.addAttribute("reviews", review);
		model.addAttribute("storeName", storeName);
		
		return "store/storeReview";
	}
	
	
}

package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;
import com.quiz.store.domain.Review;

@Service
public class StoreBO {
	
	// field
	@Autowired
	private StoreMapper storeMapper;
	
	// input: X
	// output: List<Store> => 컨트롤러 한테
	public List<Store> getStoreList(){
		return storeMapper.selectStoreList();
	}
		
	// input: id, name
	// output: List
	public List<Review> getStoreListById(int storeId) {
		return storeMapper.selectStoreListById(storeId);
	}
}

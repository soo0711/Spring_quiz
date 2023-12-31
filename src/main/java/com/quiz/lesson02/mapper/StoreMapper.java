package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;
import com.quiz.store.domain.Review;
@Mapper
public interface StoreMapper {

	public List<Store> selectStoreList();
	
	// input: id
	// output: List
	public List<Review> selectStoreListById(int storeId);
}

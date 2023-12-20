package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	// input: id      output: RealEstate(있거나 또는 null)
	public RealEstate selectRealEstateById(int id);
	
	// input: rentPrice      output: List<RealEstate>([] 또는 채워져있거나)
	public List<RealEstate> selectRealEstateByRentPrice(int rentPrice);
	
	public List<RealEstate> selectRealEstateByAreaPrice(
			// myBatis 문법 상 파라미터는 단 한개만 xml로 보낼 수 있다.
			// 파라미터들을 하나의 Map에 담아서 보낸다.
			// Map으로 만들어주는 어노테이션 = @Param
			@Param("area") int area,
			@Param("price") int price);
	
	// input: RealEstate		output: 성공한 행의 개수
	public int insertRealEstate(RealEstate realEstate);
	
	// input: @Param int realtor_id, String address
	// , int area, String type, int price, int rentPrice
	// output: 성공한 행의 개수
	public int insertRealEstateByRealtorId(
			@Param("realtorId")int realtorId, 
			@Param("address")String address, 
			@Param("area")int area, 
			@Param("type")String type, 
			@Param("price")int price, 
			@Param("rentPrice")int rentPrice);
	
	// input: id, type, price
	// output: 성공 행의 개수
	public int updateRealEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price);
	
	// input: id
	// output: 성공 행의 개수
	public int deleteRealEstateById(int id);
}

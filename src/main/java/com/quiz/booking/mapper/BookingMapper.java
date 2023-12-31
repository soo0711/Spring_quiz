package com.quiz.booking.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	// input: X
	// output: List<Booking>
	public List<Booking> selecctBookingList();
	
	// input: id
	// output: int
	public int deleteBookingById(int id);
	
	// int: name, date, day, headcount, phoneNumber
	// output: int
	public int addBooking(
			@Param("name") String name,
			@Param("date") Date date, 
			@Param("day") int day,
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	// int: name, phoneNumber
	// output: List<Booking>
	public List<Booking> selectBookingByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
	
	// int: name, phoneNumber
	// output: List<Booking>
	public List<Booking> selectBookingByName(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}

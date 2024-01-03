package com.quiz.booking.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.booking.domain.Booking;

@Repository
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
}

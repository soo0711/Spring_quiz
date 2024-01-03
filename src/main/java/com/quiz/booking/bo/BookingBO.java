package com.quiz.booking.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	@Autowired
	private BookingMapper bookingMapper;
	
	// input: X
	// output: List<Booking>
	public List<Booking> getBookingList(){
		return bookingMapper.selecctBookingList();
	}
	
	// input: id
	// output: int
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	// int: name, date, day, headcount, phoneNumber
	// output: int
	public int addBooking(String name, Date date, int day, int headcount, String phoneNumber) {
		return bookingMapper.addBooking(name, date, day, headcount, phoneNumber);
	}
}

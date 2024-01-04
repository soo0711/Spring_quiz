package com.quiz.booking;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking-list-view")
	public String bookingListView(
			Model model) {
		
		// select
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// model
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	@ResponseBody
	@RequestMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber){
		
		//select
		List<Booking> bookingList = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		// Booking bookingList = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber); 로 하는 방법
		// booking으로 받는 방법 생각하기
		
		// 성공 여부
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		result.put("bookingList", bookingList);
		
		return result;
	}
	
	@ResponseBody
	@DeleteMapping("/deleteBooking")
	public Map<String, Object> deleteBookingById(
			@RequestParam("id") int id){
		
		// delete
		int rowCount = bookingBO.deleteBookingById(id);
		
		// 성공 여부
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패했습니다.");
		}
		return result;
	}
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber){
		
		// insert
		int rowCount = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패했습니다.");
		}
		
		return result;
	}
	
}

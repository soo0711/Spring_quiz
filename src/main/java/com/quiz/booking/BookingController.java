package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@RequestMapping("/booking-list-view")
	public String bookingListView(
			Model model) {
		
		// select
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// model
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	
	@RequestMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
}

package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@Controller
@RequestMapping("/weather-history")
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@RequestMapping("/weather-list-view")
	public String weatherListView(
			Model model) {
		// select
		List<WeatherHistory> list = weatherHistoryBO.getWeatherHistory();
		
		// model
		model.addAttribute("lists", list);
		
		return "weather_history/weatherList";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	
	
}

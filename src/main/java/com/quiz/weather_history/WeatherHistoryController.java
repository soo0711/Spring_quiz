package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@Controller
@RequestMapping("/weather-history")
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;

	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
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

	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust, 
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation, 
			@RequestParam("windSpeed") double windSpeed) {

		// insert
		weatherHistoryBO.addWeather(date, weather, microDust, 
				temperatures, precipitation, windSpeed);

		// redirect: 302
		// 1. HttpServletRequest request로 하기
		// 2.
		return "redirect:/weather-history/weather-list-view";
	}

}

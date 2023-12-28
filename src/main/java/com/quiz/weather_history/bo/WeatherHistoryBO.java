package com.quiz.weather_history.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	// input: X 
	// output: List<WeatherHistory>
	public List<WeatherHistory> getWeatherHistory(){
		return weatherHistoryMapper.selectWeatherHistory();
	}
	
	// input: Weather
	// output: X
	public void addWeather(Date date, String weather, String microDust, 
			double temperatures,double precipitation,double windSpeed) {
		weatherHistoryMapper.addWeather(date, weather, microDust, 
				temperatures, precipitation, windSpeed);
	}
}

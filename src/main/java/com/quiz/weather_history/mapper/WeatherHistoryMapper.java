package com.quiz.weather_history.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {

	// input: X 
	// output: List<WeatherHistory>
	public List<WeatherHistory> selectWeatherHistory();
	
	// input: Weather
	// output: X
	public void addWeather(
			@Param("date") Date date,
			@Param("weather") String weather,
			@Param("microDust") String microDust, 
			@Param("temperatures") double temperatures,
			@Param("precipitation") double precipitation, 
			@Param("windSpeed") double windSpeed);
	
}

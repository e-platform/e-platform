package sample.weatherservice.service;

import sample.weatherservice.bean.Weather;

public interface IWeatherService {
	void setWeather(Weather w);

	Weather getWeather(String name);
}

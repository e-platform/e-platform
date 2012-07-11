package sample.weatherservice.service.impl;

import sample.weatherservice.bean.Weather;
import sample.weatherservice.service.IWeatherService;

public class WeatherService implements IWeatherService {
	Weather weather;

	public void setWeather(Weather w) {
		System.out.println("========================set weather================"+w);
		weather = w;
	}

	public Weather getWeather(String name) {
		System.out.println("========================name================"+name);
		return weather;
	}
}
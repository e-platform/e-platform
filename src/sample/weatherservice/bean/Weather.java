package sample.weatherservice.bean;

public class Weather {
	float temperature;
	String forecast;
	boolean rain;
	float howMuchRain;

	public void setTemperature(float temp) {
		temperature = temp;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setForecast(String fore) {
		forecast = fore;
	}

	public String getForecast() {
		return forecast;
	}

	public void setRain(boolean r) {
		rain = r;
	}

	public boolean getRain() {
		return rain;
	}

	public void setHowMuchRain(float howMuch) {
		howMuchRain = howMuch;
	}

	public float getHowMuchRain() {
		return howMuchRain;
	}

	@Override
	public String toString() {
		return "Weather [forecast=" + forecast + ", howMuchRain=" + howMuchRain
				+ ", rain=" + rain + ", temperature=" + temperature
				+ ", getForecast()=" + getForecast() + ", getHowMuchRain()="
				+ getHowMuchRain() + ", getRain()=" + getRain()
				+ ", getTemperature()=" + getTemperature() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}

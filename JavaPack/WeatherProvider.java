package JavaPack;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider = null;
	
	private String[] weather = {
		"RAIN",
		"FOG",
		"SUN",
		"SNOW"
	};
	
	private WeatherProvider() { }

	public static WeatherProvider getProvider()
	{
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		return this.weather[( coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() ) % 4];
	}
}
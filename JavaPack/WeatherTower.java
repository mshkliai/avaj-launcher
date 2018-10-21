package JavaPack;

class WeatherTower extends Tower
{
	private int 			countWeather;
	private WeatherProvider weatherProvider;

	public String getWeather(Coordinates coordinates)
	{
		return weatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	public void		setCount(int value)
	{
		this.countWeather = value;
	}

	public int 		getCount()
	{
		return this.countWeather;
	}

	void	changeWeather()
	{
		super.conditionsChanged();
	}
}
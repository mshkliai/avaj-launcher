package JavaPack;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);

 		System.out.println("Baloon#" + this.name + "(" + id + ") registered to weather tower.");
	}

 	private	void		Sun()
 	{
 		this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
 		this.coordinates.setHeight(this.coordinates.getHeight() + 4);
		System.out.println("Baloon#" + this.name + "(" + id + ") Let's enjoy the good weather and take some pics.");
 	}
 	
	private	void		Rain()
	{
		this.coordinates.setHeight(this.coordinates.getHeight() - 5);
		System.out.println("Baloon#" + this.name + "(" + id + ") Damn you rain! You messed up my baloon.");
	}

 	private	void		Fog()
 	{
 		this.coordinates.setHeight(this.coordinates.getHeight() - 3);
		System.out.println("Baloon#" + this.name + "(" + id + ") I can't see anything!");
 	}

 	private	void		Snow()
 	{
 		this.coordinates.setHeight(this.coordinates.getHeight() - 15);
		System.out.println("Baloon#" + this.name + "(" + id + ") My rotor is going to freeze!");
 	}

	public void updateConditions()
 	{
 		switch ( this.weatherTower.getWeather(this.coordinates) )
 		{
 			case "RAIN":
 				this.Rain();
 				break;
 			case "FOG":
 				this.Fog();
 				break;
 			case "SUN":
 				this.Sun();
 				break;
 			default:
 				this.Snow();
 		}

 		if (this.coordinates.getHeight() <= 0) 
 		{
 			System.out.println("Baloon#" + this.name + "(" + id + ") landing.");
 			this.weatherTower.unregister(this);
 			System.out.println("Baloon#" + this.name + "(" + id + ") unregistered from weather tower.");
 		}
 	}
}
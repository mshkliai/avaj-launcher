package JavaPack;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower = new WeatherTower();

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
 		System.out.println("Helicopter#" + this.name + "(" + id + ") registered to weather tower.");
	}

 	private	void		Sun()
 	{
 		this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
 		this.coordinates.setHeight(this.coordinates.getHeight() + 2);
 		System.out.println("Helicopter#" + this.name + "(" + id + ") This is hot.");
 	}
 	
	private	void		Rain()
	{
		this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
 		System.out.println("Helicopter#" + this.name + "(" + id + ") It's raining. Better watch out for lightings.");
	}

 	private	void		Fog()
 	{
 		this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
 		System.out.println("Helicopter#" + this.name + "(" + id + ") We have a some Fog");
 	}

 	private	void		Snow()
 	{
 		this.coordinates.setHeight(this.coordinates.getHeight() - 12);
 		System.out.println("Helicopter#" + this.name + "(" + id + ") OMG! Winter is coming!");
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
 			System.out.println("Helicopter#" + this.name + "(" + id + ") landing.");
 			this.weatherTower.unregister(this);
 			System.out.println("Helicopter#" + this.name + "(" + id + ") unregistered from weather tower.");
 		}
 	}
}
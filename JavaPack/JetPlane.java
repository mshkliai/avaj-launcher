 package JavaPack;

 public class JetPlane extends Aircraft implements Flyable
 {
 	private WeatherTower weatherTower = new WeatherTower();

 	JetPlane(String name, Coordinates coordinates)
 	{
 		super(name, coordinates);
 	}

 	public void registerTower(WeatherTower weatherTower)
 	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
 		System.out.println("JetPlane#" + this.name + "(" + id + ") registered to weather tower.");
 	}
	
	private	void		Sun()
 	{
 		this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
 		this.coordinates.setHeight(this.coordinates.getHeight() + 2);
 		System.out.println("JetPlane#" + this.name + "(" + id + ") Yeeeeeah =)");
 	}
 	
 	private	void		Rain()
 	{
 		this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
 		System.out.println("JetPlane#" + this.name + "(" + id + ") Ohh f**king rain =C");
 	}

 	private	void		Fog()
 	{
 		this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
 		System.out.println("JetPlane#" + this.name + "(" + id + ") I need thermal imager");
 	}

 	private	void		Snow()
 	{
 		this.coordinates.setHeight(this.coordinates.getHeight() - 7);
 		System.out.println("JetPlane#" + this.name + "(" + id + ") Cool snow -_-");
 	}

 	public void updateConditions()
 	{
 		switch ( (this.weatherTower.getWeather(this.coordinates)) )
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
 			System.out.println("JetPlane#" + this.name + "(" + id + ") landing.");
 			this.weatherTower.unregister(this);
 			System.out.println("JetPlane#" + this.name + "(" + id + ") unregistered from weather tower.");
 		}
 	}
 }
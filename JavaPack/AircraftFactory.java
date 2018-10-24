package JavaPack;
import java.io.*;

public class AircraftFactory
{
	
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws MyErrors
	{
		Flyable    newAircraft = null;
		Coordinates cords = new Coordinates(longitude, latitude, height);

		switch (type)
		{
			case "Helicopter":
				newAircraft = new Helicopter(name, cords);
				break;
			case "JetPlane":
				newAircraft = new JetPlane(name, cords);
				break;
			case "Baloon":
				newAircraft = new Baloon(name, cords);
				break;
			default:
				throw new MyErrors("Unknown type of Aircraft");
		}

		return newAircraft;
	}
	
}
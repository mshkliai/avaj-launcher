package JavaPack;

import java.io.*;

public class Main
{
	public static void main(String[] args) throws MyErrors
	{
		

		if (args.length == 1)
		{
			Parser	parser = new Parser();
			WeatherTower weatherTower = new WeatherTower();
			
			try
			{	
				parser.parse(args[0], weatherTower);
				
				for (int i = 0; i < weatherTower.getCount(); i++) {
					weatherTower.changeWeather();
				}
			}
			catch (MyErrors ex) {
				System.err.println(ex.getMessage());
			}
		}
		else {
			System.err.println("Usage: java JavaPack.Main test");
		}
	}
}
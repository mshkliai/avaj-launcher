package JavaPack;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Parser
{
	private String[] fileContent;
	private AircraftFactory factory = new AircraftFactory();
	private ArrayList<Flyable> planes = new ArrayList<Flyable>();

	private void reader(String fileName) throws MyErrors
	{
		try ( FileReader fr = new FileReader(fileName) )
		{
			int i;
			String content = new String();

			while ( (i = fr.read()) != -1) {
				content += (char)i;
			}
			this.fileContent = content.split("\n", 0);
		}
		catch (IOException ex) {
			throw new MyErrors(ex.getMessage());
		}
	}

	private void countWeather(String str, WeatherTower weatherTower) throws MyErrors
	{
		if (str.matches("^[0-9]+") == false) {
			throw new MyErrors("Error at line 1: Bad count of changes of weather");
		}
		else 
		{
			try {
				weatherTower.setCount( Integer.parseInt(str) );
			}
			catch (NumberFormatException ex) {
				throw new MyErrors("Overflow int");
			}
		}
	}

	private void parsePlane(String str, int numLine, WeatherTower weatherTower) throws MyErrors
	{
		String [] brokenStr = str.split(" ", 0);

		if (brokenStr.length != 5) {
			throw new MyErrors("Error at line " + numLine + ": Invalid initialization of Aircraft: [TYPE NAME LONGITUDE LATITUDE HEIGHT]");
		}
		else
		{
			int[] intParameters = new int[3];

			if (brokenStr[1].matches("^[0-9A-Za-z]+") == false) {
				throw new MyErrors("Error at line " + numLine + ": Bad name of Aircraft");
			}

			for (int i = 2; i < 5; i++)
			{
				if (brokenStr[i].matches("^[0-9]+") == false) {
					throw new MyErrors("Error at line " + numLine + ": Bad coordinate");
				}
				else
				{
					try {
					 	intParameters[i - 2] = Integer.parseInt(brokenStr[i]);
					}
					catch (NumberFormatException ex) {
						throw new MyErrors("Error at line " + numLine + ": Overflow int value of coordinate");
					}
				}
			}
			
			if (intParameters[0] > 0) {
				this.planes.add(this.factory.newAircraft(brokenStr[0], brokenStr[1],
		 			intParameters[0], intParameters[1], intParameters[2]));
			}
		}
	}

	public void parse(String fileName, WeatherTower weatherTower) throws MyErrors
	{
		this.reader(fileName);

		for (int i = 0; i < this.fileContent.length; i++)
		{
			if (i == 0) {
				this.countWeather(this.fileContent[i], weatherTower);
			}
			else
				this.parsePlane(this.fileContent[i], i + 1, weatherTower);
		}

		try {
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("simulation.txt")), true));		
		}
		catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		for (Flyable plane: this.planes) {
			plane.registerTower(weatherTower);
		}
	}
}
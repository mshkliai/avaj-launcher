package JavaPack;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude()
	{
		return this.longitude;
	}

	public int getLatitude()
	{
		return this.latitude;
	}

	public int getHeight()
	{
		return this.height;
	}

	public void setLongitude(int longitude)
	{
		this.longitude = longitude;
	}

	public void setLatitude(int latitude)
	{
		this.latitude = latitude;
	}

	public void setHeight(int height)
	{
		this.height = height;

		if (this.height > 100) {
			this.height = 100;
		}
		else if (this.height < 0) {
			this.height = 0;
		}
	}
}
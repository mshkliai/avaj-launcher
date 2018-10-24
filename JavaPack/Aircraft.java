package JavaPack;

public  class 				Aircraft
{
	protected long 			id;
	protected String 		name;
	protected Coordinates	coordinates;

	private	static  long	idCounter = 0;

	protected	Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = ++idCounter;
	}

	private		long nextId;

	public 		long	getId()
	{
		return this.id;
	}

	public 		String getName()
	{
		return this.name;
	}
}
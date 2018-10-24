package JavaPack;

import java.util.ArrayList;

public class Tower
{
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		this.observers.add(flyable);
		System.out.printf("Tower says: ");
	}

	public void unregister(Flyable flyable)
	{
		System.out.printf("Tower says: ");
		this.observers.remove(flyable);
	}

	protected void conditionsChanged()
	{
		for (int i = 0; i < this.observers.size(); i++) {
			this.observers.get(i).updateConditions();
		}
	}
}

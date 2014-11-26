public class Battery 
{
	private static final int DEFAULT_LIFESPAN = 100;	
	int currentPower; 
	
	public Battery()
	{
		this(DEFAULT_LIFESPAN); 
	}
	
	public Battery(int lifeSpan)
	{
		currentPower = lifeSpan; 
		useBattery(); 
	}
	
	public void useBattery()
	{
		while (currentPower >= 0)
		{
			System.out.println(currentPower); 
			currentPower--; 
		}
	}
}

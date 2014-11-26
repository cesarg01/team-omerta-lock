public class Battery 
{
	private static final int DEFAULT_LIFESPAN = 100;	
	int currentPower; 
	int lifeSpan; 
	
	/**
	 * Constructor
	 */
	public Battery()
	{
		this(DEFAULT_LIFESPAN); 
	}
	
	/**
	 * Constructor
	 * @param lifeSpan
	 */
	public Battery(int lifeSpan)
	{
		this.lifeSpan = lifeSpan;
		currentPower = lifeSpan; 
		useBattery(); 
	}
	
	public void useBattery()
	{
		while (currentPower >= 0)
		{
			System.out.println(currentPower); 
			currentPower--;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getCurrentPowerPercent()
	{
		return currentPower / lifeSpan * 100; 
	}
}

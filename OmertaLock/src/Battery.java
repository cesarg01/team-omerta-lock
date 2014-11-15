public class Battery 
{
	int lifeSpan = 100;
	
	public int getRemainingLifePercent()
	{
		if(lifeSpan == 0)
		{
			System.out.println("Lock is out of battery!");
			return 0;
		}
		return lifeSpan -= 1;
		
	}

}

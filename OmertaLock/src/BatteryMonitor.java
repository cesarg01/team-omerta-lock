public class BatteryMonitor
{
	int currentLifeRemainingPercent;
	Battery currentBattery = new Battery();
	
	public void lowLifeAlert()
	{
		if(currentBattery.getRemainingLifePercent() == 20)
		{
			System.out.println("Low on battery!");
		}
	}
}

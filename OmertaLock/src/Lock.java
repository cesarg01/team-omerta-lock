
public class Lock {
	
	PIN_List pins = new PIN_List();
	//InputMonitor inputMonitor = new InputMonitor();
	BatteryMonitor batteryMonitor = new BatteryMonitor();
	boolean isLocked = true;
	boolean isFrozen = false;
	//LED lockLED = new lockLED();
	//Beeper lockBeeper = new Beeper();
	//InputInterpreter
	
	public void interpretInput()
	{
		
	}
	
	public boolean unlock()
	{
		return isLocked = false;
	}
	
	public boolean relock()
	{
		return isLocked = true;
	}
	
	public void changeMode()
	{
		
	}
	
	public void changeRelockTime()
	{
		
	}
	
	public boolean freezeLock()
	{
		return isFrozen = false;
	}
	
	public boolean unfreezeLock()
	{
		return isFrozen = true;
	}
	
	public void checkMode()
	{
		
	}
	
	public void resetLock(PIN_List pins)
	{
		pins = new PIN_List();
	}
	
	public void restoreSetting()
	{
		
	}
	
	public void selfDestruct()
	{
		
	}
}

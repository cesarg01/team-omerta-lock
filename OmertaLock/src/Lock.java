
public class Lock {
	
	private static final PIN DEFAULT_PROGRAMMING_PIN = new PIN(12345);
	private static final PIN DEFAULT_NORMALUSE_PIN = new PIN(54321); 
	
	PIN_List pinList;
	//InputMonitor inputMonitor = new InputMonitor();
	BatteryMonitor batteryMonitor = new BatteryMonitor();
	boolean isLocked = true;
	boolean isFrozen = false;
	//LED lockLED = new lockLED();
	//Beeper lockBeeper = new Beeper();
	//InputInterpreter
	
	/**
	 * Constructor
	 */
	public Lock()
	{
		pinList = new PIN_List();
		loadFactoryDefaults();		 
	}
	
	private void loadFactoryDefaults()
	{
		pinList.insert(DEFAULT_PROGRAMMING_PIN);
		pinList.insert(DEFAULT_NORMALUSE_PIN); 
	}
	
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

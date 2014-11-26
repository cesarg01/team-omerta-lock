
public class PIN
{
	private static int pinLength;
	private int pin;
	private enum pinType {ADMIN, addPIN, deletePIN, toggleBeeper, relockTime};
	private boolean pinEnabled = true;
	
	public PIN(int newPIN)
	{
		pin = newPIN; 
	}
	
	/**
	 * Set the pin length.
	 */
	public void setPinLength(int length)
	{
		pinLength = length;
	}
		
	/**
	 * Enable PIN.
	 */
	public void enablePIN()
	{
		pinEnabled = true;
	}
	
	/**
	 * Disable PIN.
	 */
	public void disablePIN()
	{
		pinEnabled = false;
	}
	
	/**
	 * Get the PIN type.
	 */
	public void getPinType()
	{
		
	}
	
	public int getPinNum()
	{
		return pin; 
	}
	
	/**
	 * Check if the PIN is equal.
	 */
	public void equals()
	{
		
	}
	
}

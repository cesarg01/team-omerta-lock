
public class PIN
{
	private static int pinLength;
	private int pin;
	private enum pinType {ADMIN, addPIN, deletePIN, toggleBeeper, relockTime};
	private boolean pinEnabled;
	
	public PIN(int newPIN)
	{
		pin = newPIN; 
		pinEnabled = true; 
	}
	
	/**
	 * Set the pin length.
	 */
	public void setPinLength(int length)
	{
		pinLength = length;
	}
	
	/**
	 * Get pin length
	 * @return length of pin
	 */
	public int getPinLength()
	{
		return pinLength;
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
	public boolean equals(PIN pin)
	{
		if (this.pin - pin.getPinNum() == 0)
			return true; 
		else 
			return false; 
	}
	
}

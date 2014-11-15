
public class PIN
{
	private int pinLength;
	private int pin;
	private enum pinType {ADMIN, addPIN, deletePIN, toggleBeeper, relockTime};
	private boolean pinEnabled = true;
	
	
	/**
	 * Set the pin length.
	 */
	public void setPinLength()
	{
		pinLength = 4;
	}
	
	/**
	 * Set the pin.
	 */
	public void setPIN(int pin)
	{
		this.pin = pin;
	}
	
	/**
	 * Enable PIN.
	 */
	public void enablePIN()
	{
		this.pinEnabled = true;
	}
	
	/**
	 * Disable PIN.
	 */
	public void disablePIN()
	{
		this.pinEnabled = false;
	}
	
	/**
	 * Get the PIN type.
	 */
	public void getPinType()
	{
		
	}
	
	/**
	 * Check if the PIN is equal.
	 */
	public void equals()
	{
		
	}
	
}

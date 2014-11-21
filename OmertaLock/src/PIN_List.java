import java.util.*;

public class PIN_List extends PIN
{
	Hashtable<String, String> pinList;

	/**
	 * Constructor
	 */
	public PIN_List()
	{

		pinList = new Hashtable<String, String>();
	}
	
	/**
	 * Adds a pin to the hashtable.
	 * @param pinType Type of pin
	 * @param pin Pin
	 */
	public void addPIN(String pinType, String pin)
	{
		pinList.put(pinType, pin);
	}
	
	/*
	 * Check the pinType
	 */
	public void checkPinType()
	{
		getPinType();
	}
	
	/**
	 * Remove pin
	 * @param pinType The pin type to be remove.
	 */
	public void removePIN(String pinType)
	{
		pinList.remove(pinType);
	}
	
	public void hashFunction()
	{
		
	}
	
}

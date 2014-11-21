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
	
	
	public void addPIN(String key, String value)
	{
		pinList.put(key, value);
	}
	
	public void checkPinType()
	{
		getPinType();
	}
	
	public void removePIN(String key)
	{
		pinList.remove(key);
	}
	
	public void hashFunction()
	{
		
	}
	
}

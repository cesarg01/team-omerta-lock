import java.util.*;

public class PIN_List extends PIN
{
	private static final int DEFAULT_TABLE_SIZE = 100; 
	final int DEFAULT_TABLE_VALUE = 0; 
	int[] hashTable;
	int currentSize; 

	/**
	 * Constructor
	 */
	public PIN_List()
	{
		this(DEFAULT_TABLE_SIZE); 
	}
	
	 
	private PIN_List( int size )
	{
		allocateHashTable(size); 
		makeEmpty(); 
	}
	
	private void allocateHashTable( int size )
	{
		hashTable = new int[size]; 
	}
	
	private void makeEmpty()
	{
		currentSize = 0; 
		for( int i = 0; i < hashTable.length; i++ )
			hashTable[ i ] = DEFAULT_TABLE_VALUE; 
	}
	
	/**
	 * 
	 * @param pin
	 */
	public void insert( int pin )
	{
		// 1. Make sure the PIN isn't already 
		//    in the hash table. 
		// 2. Hash the PIN to determine what 
		//    index to insert it at. 
		// 3. Assign the PIN to the index. 
		
		// 1
		if ( !contains(pin) )
			// 2 and 3
			hashTable[ hash(pin) ] = pin;		
	}
	
	public void remove( int pin )
	{
	
	}
	
	public boolean contains( int pin )
	{
		return true; 
	}
	
	public int hash( int pin )
	{
		return (pin % 99); 
	}
	
	
	
	/*
	 * Check the pinType
	 */
	public void checkPinType()
	{
		getPinType();
	}
}

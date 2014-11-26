import java.util.*;

public class PIN_List
{
	private static final int DEFAULT_TABLE_SIZE = 100; 
	
	HashEntry<PIN>[] hashTable;
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
		hashTable = new HashEntry[size]; 
	}
	
	private void makeEmpty()
	{
		currentSize = 0; 
		for( int i = 0; i < hashTable.length; i++ )
			hashTable[ i ] = null; 
	}
	
	private static class HashEntry<PIN>
	{
		public PIN element; 
		public boolean deleted; 
		
		public HashEntry( PIN pin )
		{
			this( pin, false ); 
		}
		
		public HashEntry( PIN pin, boolean bool )
		{
			element = pin; 
			deleted = bool; 
		}
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
}

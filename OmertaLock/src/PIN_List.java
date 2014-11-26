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
		public boolean isActive; 
		
		public HashEntry( PIN pin )
		{
			this( pin, false ); 
		}
		
		public HashEntry( PIN pin, boolean bool )
		{
			element = pin; 
			isActive = bool; 
		}
	}
	
	public boolean contains( PIN pin )
	{
		int currentPos = findPos(pin); 
		return isActive(currentPos); 
	}
	
	private int findPos( PIN pin )
	{
		int offset = 1; // linear probing
		int currentPos = hash( pin ); 
		int beginningOfHashTable = 0; 
		
		while( hashTable[currentPos] != null && 
				!hashTable[currentPos].element.equals(pin) )
		{
			currentPos += offset; 
			if( currentPos >= hashTable.length )
				currentPos = beginningOfHashTable; 
		}
		
		return currentPos; 		
	}
	
	private boolean isActive( int currentPos )
	{
		return hashTable[ currentPos ] != null && hashTable[ currentPos ].isActive;
	}
	
	/**
	 * 
	 * @param pin
	 */
	public void insert( PIN pin )
	{
		// 1. Make sure the PIN isn't already 
		//    in the hash table. 
		// 2. Hash the PIN to determine what 
		//    index to insert it at. 
		// 3. Assign the PIN to the index.
		int currentPos = findPos(pin); 
		if ( !isActive(currentPos) )
			return;
		
		hashTable[currentPos] = new HashEntry<PIN>(pin, true);
		
		if ( ++currentSize > hashTable.length / 2 )
			rehash(); 
	}
	
	public void remove( PIN pin )
	{
		int currentPos = findPos(pin);
		
		if ( !isActive(currentPos) )
			hashTable[currentPos].isActive = false; 
	}
	
	public boolean contains( int pin )
	{
		return true; 
	}
	
	public int hash( PIN pin )
	{
		int pinNum = pin.getPinNum(); 
		return (pinNum % 99); 
	}
	
	private void rehash()
	{
		HashEntry<PIN>[] oldHashTable = hashTable; 
		
		allocateHashTable( 2 * oldHashTable.length );
		currentSize = 0; 
		
		for ( int k = 0; k < oldHashTable.length; k++ )
			if( oldHashTable[k] != null && oldHashTable[k].isActive )
				insert( oldHashTable[k].element ); 
	}
}

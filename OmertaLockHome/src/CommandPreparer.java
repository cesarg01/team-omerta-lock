import java.util.ArrayList;

/**
 * Prepares the commands for the lock.
 */
public class CommandPreparer 
{
	private static final String STAR = "*"; 
	private static final String POUND = "#";
	private static final String OMERTA = "Omerta";
	private static final String BLANK = "";
	private static final Integer BLANK_FINAL_COMMAND = 0;
	
	private ArrayList<String> commandSoFar; 
	private boolean commandReady;
	private boolean justANumberEntry; 
	private boolean special; 
	private PIN finalCommand; 
	
	/**
	 * Constructor
	 */
	public CommandPreparer()
	{
		resetCommandPreparer(); 
	}	
	
	/**
	 * Resets the command
	 */
	public void resetCommandPreparer()
	{
		commandSoFar = new ArrayList<String>();
		justANumberEntry = false; 
		commandReady = false;
		special = false; 
	}
	
	/**
	 * Resets number
	 */
	public void resetJustANumberFlag()
	{
		justANumberEntry = false; 
	}
	
	/**
	 * Resets a special key
	 */
	public void resetSpecialFlag()
	{
		special = false; 
	}
	
	/**
	 * Gets the next input.
	 * @param nextInput the input from the keypad
	 */
	public void getNextInput(String nextInput)
	{
		handleNextInput(nextInput); 
	}
	
	/**
	 * Handles the input
	 * @param nextInput the input being handled
	 */
	private void handleNextInput(String nextInput)
	{
		// if input is a number, add to arraylist
		if ( isNumber(nextInput) )
		{
			commandSoFar.add( nextInput ); 
			justANumberEntry = true; 
			//System.out.println("successful add!"); 
		}
		
		// if input is a pound...
		if ( isPound(nextInput) )
		{
			prepareCommand();
			commandReady = true; 
			if (special == true)
				special = false; 
		}
		
		// if input is a star...
		if ( isStar(nextInput) )
		{
			resetCommandPreparer(); 
			justANumberEntry = true; // THIS MUST COME AFTER resetCommandPreparer()			
		}
		
		// if input is logo button
		if ( isLogoButton(nextInput) )
		{
			resetCommandPreparer();
			special = true; 
		}
	}
	
	/**
	 * Prepare the command
	 */
	private void prepareCommand()
	{
		String fullCommand = new String();		
		
		for (int k = 0; k < commandSoFar.size(); k++)
		{
			fullCommand += commandSoFar.get(k);
		}		
		
		if (fullCommand.length() == BLANK_FINAL_COMMAND || fullCommand.length() > PIN.PIN_MAX_LENGTH)
		{			
			finalCommand = new PIN( BLANK_FINAL_COMMAND );
		}
		else		
		{
			finalCommand = new PIN( Integer.parseInt(fullCommand) );
		}			 
	}
	
	/**
	 * Check if the input was the Omerta button
	 * @param str the input we are checking
	 * @return true if Omerta was pressed otherwise false
	 */
	private boolean isLogoButton(String str)
	{
		if ( str.equals(OMERTA) )
			return true;
		return false;
	}
	
	/**
	 * Check to see if the input is a pound.
	 * @param str the input we are checking.
	 * @return true if input is pound otherwise false.
	 */
	private boolean isPound(String str)
	{
		if ( str.equals(POUND) )
			return true; 
		return false; 
	}
	
	/**
	 * Check to see if the input is a star.
	 * @param str the input we are checking
	 * @return true if input is star otherwise false.
	 */
	private boolean isStar(String str)
	{
		if ( str.equals(STAR) )
			return true; 
		else return false; 
	}
	
	/**
	 * Check to see if the input is a number.
	 * @param str the input we are checking
	 * @return true if input is a number otherwise false.
	 */
	private boolean isNumber(String str)
	{
		if ( !str.equals(STAR) && !str.equals(POUND) && !str.equals(OMERTA) )
			return true; 
		return false; 
	}
	
	/**
	 * Check if the last input was a numbered entry
	 * @return the value true or false.
	 */
	public boolean lastInputJustANumberEntry()
	{
		return justANumberEntry; 
	}
	
	/**
	 * Check to see if the command is ready.
	 * @return the value true or false.
	 */
	public boolean commandIsReady()
	{
		return commandReady; 
	}
	
	/**
	 * Checks to see if the command is a special.
	 * @return the value true or false.
	 */
	public boolean special()
	{
		return special; 
	}
	
	/**
	 * Gets the command.
	 * @return the complete command.
	 */
	public PIN getCommand()
	{
		return finalCommand;
	}
}

import java.util.ArrayList;


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
	
	public CommandPreparer()
	{
		resetCommandPreparer(); 
	}	
	
	public void resetCommandPreparer()
	{
		commandSoFar = new ArrayList<String>();
		justANumberEntry = false; 
		commandReady = false;
		special = false; 
	}
	
	public void resetJustANumberFlag()
	{
		justANumberEntry = false; 
	}
	
	public void resetSpecialFlag()
	{
		special = false; 
	}
	
	public void getNextInput(String nextInput)
	{
		handleNextInput(nextInput); 
	}
	
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
	
	private boolean isLogoButton(String str)
	{
		if ( str.equals(OMERTA) )
			return true;
		return false;
	}
	
	private boolean isPound(String str)
	{
		if ( str.equals(POUND) )
			return true; 
		return false; 
	}
	
	private boolean isStar(String str)
	{
		if ( str.equals(STAR) )
			return true; 
		else return false; 
	}
	
	private boolean isNumber(String str)
	{
		if ( !str.equals(STAR) && !str.equals(POUND) && !str.equals(OMERTA) )
			return true; 
		return false; 
	}
	
	public boolean lastInputJustANumberEntry()
	{
		return justANumberEntry; 
	}
	
	public boolean commandIsReady()
	{
		return commandReady; 
	}
	
	public boolean special()
	{
		return special; 
	}
	
	public PIN getCommand()
	{
		return finalCommand;
	}
}

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class CommandPreparer 
{
	private static final String STAR = "*"; 
	private static final String POUND = "#";
	private static final String OMERTA = "Omerta";
	
	private ArrayList<String> commandSoFar; 
	private boolean commandReady;
	private PIN finalCommand; 
	private int PIN_LENGTH = 4;
	int pinLengthSoFar = 0;
	
	public CommandPreparer()
	{
		resetCommandPreparer(); 
	}	
	
	public void getNextInput(String nextInput)
	{
		handleNextInput(nextInput); 
	}
	
	private void handleNextInput(String nextInput)
	{
		// Check the pin length so far
		if( pinLengthSoFar < PIN_LENGTH +1)
		{
			// if number, add to arraylist
			if ( isNumber(nextInput) )
			{
				commandSoFar.add( nextInput ); 
				System.out.println("successful add!"); 
				pinLengthSoFar++;
			}
			// check for pound sign
			if ( isPound(nextInput) )
			{			
				prepareCommand();
				commandReady = true; 
			}
		}
		else
		{
			//commandReady = false;
			JOptionPane.showMessageDialog(null, "PIN length is 4!");
			resetCommandPreparer();
		}
			
		
		
		
		
	}
	
	private void prepareCommand()
	{
		String fullCommand = new String(); 
		
		for (int k = 0; k < commandSoFar.size(); k++)
			fullCommand += commandSoFar.get(k); 
		
		finalCommand = new PIN( Integer.parseInt(fullCommand) ); 
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
		return false; 
	}
	
	private boolean isNumber(String str)
	{
		if ( !str.equals(STAR) && !str.equals(POUND) && !str.equals(OMERTA) )
			return true; 
		return false; 
	}
	
	public boolean commandIsReady()
	{
		return commandReady; 
	}
	
	public PIN getCommand()
	{
		return finalCommand;
	}
	
	public void resetCommandPreparer()
	{
		commandSoFar = new ArrayList<String>();
		pinLengthSoFar = 0;
		commandReady = false; 		
	}
}

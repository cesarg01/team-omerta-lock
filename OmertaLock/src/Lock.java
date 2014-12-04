
public class Lock
{	
	// Class static data
	private static final PIN DEFAULT_PROGRAMMING_PIN = new PIN(1234);
	private static final PIN DEFAULT_NORMALUSE_PIN = new PIN(4321); 	
	private CommandPreparer commandPreparer;  
	
	// Instance members
	private PIN_List pinList; 
	
	/**
	 * Constructor
	 */
	public Lock()
	{
		pinList = new PIN_List();
		loadFactoryDefaults();
		commandPreparer = new CommandPreparer(); 
	}
	
	private void loadFactoryDefaults()
	{
		pinList.insert(DEFAULT_PROGRAMMING_PIN);
		pinList.insert(DEFAULT_NORMALUSE_PIN); 
	}
	
	public void getNextInput(String nextInput)
	{
		commandPreparer.getNextInput(nextInput);
		
		if ( commandPreparer.commandIsReady() )
		{
			commandPreparer.resetCommandPreparer();
			executeCommand( commandPreparer.getCommand() ); 
		}
	}
	
	private void executeCommand(PIN command)
	{
		// Check if command is valid
		if ( !pinList.contains(command) )
		{
			Beeper.sound1.beep();
			System.out.println("Invalid PIN!");
		}
		else
		{
			Beeper.sound2.beep();
			System.out.println("Valid PIN!"); 
		}
	}
}

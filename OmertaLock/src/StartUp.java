
public class StartUp 
{
	public static void main(String[] args)
	{
		// Start model
		Lock theModel = new Lock();		
		
		// Start view
		LockView theView = new LockView(); 
		
		// Start controller
		LockController theController = new LockController(theModel, theView); 
		
		System.out.println("Hello!"); 
		
		while(true); // Leave this here at the end. Otherwise, the program terminates before the timers can work.  
	}	 
}

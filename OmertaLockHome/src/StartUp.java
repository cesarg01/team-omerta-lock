
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
	}	 
}

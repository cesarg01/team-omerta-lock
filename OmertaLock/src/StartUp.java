
public class StartUp 
{
	public static void main(String[] args)
	{
		Lock lock = new Lock();
		new Battery(); 
		System.out.println("Hello!"); 
		
		while(true); // Leave this here at the end. Otherwise, the program terminates before the timers can work.  
	}	 
}


public class StartUp 
{
	public static void main(String[] args)
	{
		Lock lock = new Lock();
		Battery battery = new Battery(); 
		battery.useBattery(); 
		System.out.println("Hello!"); 
	}	 
}

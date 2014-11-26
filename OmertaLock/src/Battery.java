import javax.swing.*; 
import javax.swing.event.*; 
import java.awt.*; 
import java.awt.event.*; 

public class Battery extends JFrame
{
	private static final int DEFAULT_LIFESPAN = 100;	
	int currentPower; 
	int lifeSpan; 
	
	private Timer timer; 	
	
	/**
	 * Constructor
	 */
	public Battery()
	{
		this(DEFAULT_LIFESPAN); 
	}
	
	/**
	 * Constructor
	 * @param lifeSpan
	 */
	public Battery(int lifeSpan)
	{
		this.lifeSpan = lifeSpan;
		currentPower = lifeSpan; 
		timer = new Timer(1000, new TimerListener());		 
		timer.start(); 
	}
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			System.out.println( getCurrentPowerPercent() );
				
			if (getCurrentPowerPercent() <= 25)
				System.out.println("low battery! blink red and beep");
			
			currentPower--; 			 
			
			if (currentPower == 0)
				timer.stop(); 
		}
	}
	
	public int getCurrentPowerPercent()
	{
		int percent = currentPower * 100 / lifeSpan;		
		return percent; 
	}
}

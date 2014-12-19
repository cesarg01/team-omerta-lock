import javax.swing.*; 
import javax.swing.event.*; 
import java.awt.*; 
import java.awt.event.*; 

/**
 * Class that simulates a battery on a lock. 
 *
 */
public class Battery extends JFrame
{
	public static final int LOW_BATTERY_LIFE_THRESHOLD = 30; 
	
	private static final int DEFAULT_LIFESPAN = 100;
	private static final int BATTERY_LIFE_REPORT_RATE = 1000; 
	private static final int SHOW_BATTERY_LIFE = 40; // Shows percentage at 80 and 40
	private static final int THRESHOLD_REPORT = 10; // Shows percentage at 20 , 10
	private static final int PERCENTAGE_CONVERTER = 100;
	private int currentPower; 
	private int lifeSpan; 
	
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
		timer = new Timer(BATTERY_LIFE_REPORT_RATE, new TimerListener());		 
		timer.start(); 
	}
	
	/**
	 * Updates the battery status to the user. When the battery runs out the
	 * program exits.
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			//JOptionPane.showMessageDialog(null,getCurrentPowerPercent() + "%" + " " );
			if(getCurrentPowerPercent() % SHOW_BATTERY_LIFE == 0)
				JOptionPane.showMessageDialog(null, getCurrentPowerPercent() + "%" + " " ,"Warning", JOptionPane.WARNING_MESSAGE, null);
				
			if (getCurrentPowerPercent() <= LOW_BATTERY_LIFE_THRESHOLD)
			{
				if(getCurrentPowerPercent() % THRESHOLD_REPORT == 0)
					JOptionPane.showMessageDialog(null, "Low Battery! \n", "Warning", JOptionPane.WARNING_MESSAGE, null);
			}
			
			currentPower--; 			 
			
			if (currentPower == 0)
			{
				JOptionPane.showMessageDialog(null, "Out of Battery!", "Warning", JOptionPane.WARNING_MESSAGE, null);
				timer.stop();
				System.exit(0); 
			}
		}
	}
	
	/**
	 * Gets the current battery power percentage.
	 * @return
	 */
	public int getCurrentPowerPercent()
	{
		int percent = currentPower * PERCENTAGE_CONVERTER / lifeSpan;		
		return percent; 
	}
	
	/**
	 * Replace the battery with a new one.
	 */
	public void replace()
	{
		currentPower = lifeSpan; 
	}
}

import javax.swing.*; 
import javax.swing.event.*; 
import java.awt.*; 
import java.awt.event.*; 

public class Battery extends JFrame
{
	public static final int LOW_BATTERY_LIFE_THRESHOLD = 30; 
	
	private static final int DEFAULT_LIFESPAN = 100;
	private static final int BATTERY_LIFE_REPORT_RATE = 1000; 
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
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			//JOptionPane.showMessageDialog(null,getCurrentPowerPercent() + "%" + " " );
			if(getCurrentPowerPercent() % 40 == 0)
				JOptionPane.showMessageDialog(null, getCurrentPowerPercent() + "%" + " " ,"Warning", JOptionPane.WARNING_MESSAGE, null);
				
			if (getCurrentPowerPercent() <= LOW_BATTERY_LIFE_THRESHOLD)
			{
				if(getCurrentPowerPercent() % 10 == 0)
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
	
	public int getCurrentPowerPercent()
	{
		int percent = currentPower * 100 / lifeSpan;		
		return percent; 
	}
	
	public void replace()
	{
		currentPower = lifeSpan; 
	}
}

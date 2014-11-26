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
	public int count; 
	
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
	}
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			currentPower--; 
			if (currentPower == 0)
				timer.stop(); 
		}
	}
	
	public int getCurrentPowerPercent()
	{
		return currentPower / lifeSpan * 100; 
	}
}

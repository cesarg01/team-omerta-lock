import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer; 
import java.util.TimerTask; 

public class LockController
{
	private Lock model; 
	private LockView view;	
	
	public LockController(Lock model, LockView view)
	{
		this.model = model; 
		this.view = view; 
		
		this.view.addLockPanelListener(new LockPanelListener());
		
		batteryMonitor(); 
		
		this.view.setVisible(true); 
	}
	
	private void batteryMonitor()
	{
		long startCheckingDelay = 0; 
		long checkInterval = 10000; 
		final int lowBatteryLifeThreshold = Battery.LOW_BATTERY_LIFE_THRESHOLD; 
		
		Timer batteryTimer = new Timer(); 
		batteryTimer.scheduleAtFixedRate(new TimerTask() 
		{
			public void run()
			{
				if ( model.getCurrentBatteryPowerPercent() <= lowBatteryLifeThreshold )
				{
					view.lowBatteryLifeWarning(); 
				}
			}
		}, startCheckingDelay, checkInterval);
		
	}
	
	class LockPanelListener implements InputListener
	{
		public void inputEventOccurred(InputEvent e)
		{
			System.out.println( "\n" + e.getBtnID() );
			model.getNextInput( e.getBtnID() ); 
			
			try
			{				
				if (model.beeperActive() == true)
					view.beep( model.getBeepDetails() );
				else
					view.beep( new Beeper(false) );
			}
			catch (Exception err)
			{
				System.out.println("Do more sound programming.");  
			}
			
			try
			{				 
				view.blink( model.getBlinkDetails() );
			}
			catch (Exception ex)
			{
				System.out.println("Do more LED programming"); 
			}
		}
	}
}


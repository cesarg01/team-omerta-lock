import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class LockView extends JFrame
{
	LockPanel lockPanel; 
	Beeper lockBeeper; 
	
	public LockView()
	{
		// Try to make the GUI look cool. 
		try 
		{
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		initComponents(); 		
	}
	
	private void initComponents()
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    setTitle("Omerta Electronic Lock ");
	    setSize(270, 600);
	    setLayout(new BorderLayout());
	    
	    lockPanel = new LockPanel();
	    lockBeeper = new Beeper(); 
	    
	    Container c = getContentPane(); 
	    c.add(lockPanel, BorderLayout.CENTER); 
	}
	
	void addLockPanelListener(InputListener listenForBtns)
	{
		lockPanel.addInputListener(listenForBtns);
	}
	
	public void blink(LED blinkDetails)
	{
		lockPanel.blink(blinkDetails); 		 
	}
	
	public void beep(Beeper beepDetails)
	{
		lockBeeper = beepDetails; 
		lockBeeper.beep(); 
	}
	
	public void lowBatteryLifeWarning() 
	{
		beep(Lock.BAD_PIN_ENTRY);
		lockPanel.blink(Lock.BAD_PIN_ENTRY_LED); 		
	}
}



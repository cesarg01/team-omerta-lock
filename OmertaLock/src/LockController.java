import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockController
{
	private Lock model; 
	private LockView view;
	
	
	public LockController(Lock model, LockView view)
	{
		this.model = model; 
		this.view = view; 
		
		this.view.addLockPanelListener(new LockPanelListener()); 	
		
		this.view.setVisible(true); 
	}
	
	class LockPanelListener implements InputListener
	{
		public void inputEventOccurred(InputEvent e)
		{
			System.out.println( e.getBtnID() );
			model.getNextInput( e.getBtnID() ); 
		}
	}
}


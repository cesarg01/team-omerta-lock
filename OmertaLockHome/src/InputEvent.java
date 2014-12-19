import java.util.EventObject;

/**
 * Input events for the buttons
 *
 */
public class InputEvent extends EventObject 
{
	private String btnID; 
	
	/**
	 * Event handler
	 * @param source the object event
	 * @param btnID the button id
	 */
	public InputEvent(Object source, String btnID)
	{
		super(source);
		
		this.btnID = btnID; 
	}
	
	/**
	 * Get the id for the button.
	 * @return the button id
	 */
	public String getBtnID()
	{
		return btnID; 
	}	
}

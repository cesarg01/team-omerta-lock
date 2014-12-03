import java.util.EventObject;

public class InputEvent extends EventObject 
{
	private String btnID; 
	
	public InputEvent(Object source, String btnID)
	{
		super(source);
		
		this.btnID = btnID; 
	}
	
	public String getBtnID()
	{
		return btnID; 
	}	
}

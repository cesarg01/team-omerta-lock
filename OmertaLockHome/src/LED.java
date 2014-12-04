import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LED extends JLabel
{
	// "Global" members
	public static final String GREEN_ON = "res/greenledON.png";
	public static final String RED_ON = "res/redledON.png"; 
	public static final String GREEN_OFF = "res/greenledOFF.png"; 
	public static final String RED_OFF = "res/redledOFF.png"; 
	public static final int NO_BLINK = 0; 
	public static final int ONE_BLINK = 1; 
	public static final int TWO_BLINKS = 2; 
	public static final int THREE_BLINKS = 3; 
	public static final int FIVE_BLINKS = 5; 
	
	public static final int BLINK_DURATION = 150; // In milliseconds. 
	public static final int BLINK_WAIT_TIME = 300; // In milliseconds. Must be same time as beeper wait time. 
	
	// Instance members
	private String blinkColor; 
	private int numberOfBlinks;
	private ImageIcon restingColor; 
	
	public LED()
	{
		this(GREEN_OFF, GREEN_ON, ONE_BLINK);
	}
	
	public LED (String restingColor)
	{
		 this(restingColor, GREEN_ON, ONE_BLINK);  
	}
	
	public LED (int numberOfBlinks)
	{
		this(GREEN_OFF, GREEN_ON, numberOfBlinks); 
	}
	
	public LED (String blinkColor, int numberOfBlinks)
	{
		this(GREEN_OFF, blinkColor, numberOfBlinks); 
	}
	
	public LED (String restingColor, String blinkColor, int numberOfBlinks)
	{
		this.restingColor = new ImageIcon(restingColor); 
		setIcon(this.restingColor); 
		this.blinkColor = blinkColor; 
		this.numberOfBlinks = numberOfBlinks;  
	}
	
	public void setRestingColor(String restingColor)
	{
		this.restingColor = new ImageIcon(restingColor); 
		setIcon(this.restingColor); 
	}
	
	public ImageIcon getRestingColor()
	{
		return restingColor;
	}
	
	public void setNumberOfBlinks(int numberOfBlinks)
	{
		this.numberOfBlinks = numberOfBlinks;
	}
	
	public int getNumberOfBlinks()
	{
		return numberOfBlinks; 
	}
	
	public void setBlinkColor(String blinkColor)
	{
		this.blinkColor = blinkColor;			
	}
	
	public String getBlinkColor()
	{
		return blinkColor; 
	}
}

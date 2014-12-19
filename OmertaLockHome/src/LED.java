import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class that simulates LED lights.
 *
 */
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
	
	/**
	 * Constructor
	 */
	public LED()
	{
		this(GREEN_OFF, GREEN_ON, ONE_BLINK);
	}
	
	/**
	 * Constructor
	 * @param restingColor the off color
	 */
	public LED (String restingColor)
	{
		 this(restingColor, GREEN_ON, ONE_BLINK);  
	}
	
	/**
	 * Constructor
	 * @param numberOfBlinks the number of blinks
	 */
	public LED (int numberOfBlinks)
	{
		this(GREEN_OFF, GREEN_ON, numberOfBlinks); 
	}
	
	/**
	 * Constructor
	 * @param blinkColor the blinking color
	 * @param numberOfBlinks the number of blinks
	 */
	public LED (String blinkColor, int numberOfBlinks)
	{
		this(GREEN_OFF, blinkColor, numberOfBlinks); 
	}
	
	/**
	 * Constructor
	 * @param restingColor the resting color
	 * @param blinkColor the blink color
	 * @param numberOfBlinks the number of blinks
	 */
	public LED (String restingColor, String blinkColor, int numberOfBlinks)
	{
		this.restingColor = new ImageIcon(restingColor); 
		setIcon(this.restingColor); 
		this.blinkColor = blinkColor; 
		this.numberOfBlinks = numberOfBlinks;  
	}
	
	/**
	 * Sets the resting color
	 * @param restingColor the resting color
	 */
	public void setRestingColor(String restingColor)
	{
		this.restingColor = new ImageIcon(restingColor); 
		setIcon(this.restingColor); 
	}
	
	/**
	 * Gets the resting color.
	 * @return the resting color
	 */
	public ImageIcon getRestingColor()
	{
		return restingColor;
	}
	
	/**
	 * Set the number of blinks.
	 * @param numberOfBlinks the number of blinks
	 */
	public void setNumberOfBlinks(int numberOfBlinks)
	{
		this.numberOfBlinks = numberOfBlinks;
	}
	
	/**
	 * Get the number of blinks.
	 * @return the number of blinks
	 */
	public int getNumberOfBlinks()
	{
		return numberOfBlinks; 
	}
	
	/**
	 * Set the blinking color.
	 * @param blinkColor the blinking color
	 */
	public void setBlinkColor(String blinkColor)
	{
		this.blinkColor = blinkColor;			
	}
	
	/**
	 * Gets the blinking color.
	 * @return the blinking color
	 */
	public String getBlinkColor()
	{
		return blinkColor; 
	}
}

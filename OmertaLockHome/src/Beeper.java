import java.applet.Applet;
import java.applet.AudioClip;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Beeper class for the lock.
 *
 */
public class Beeper 
{
	// "global members" 		
	public static final String GOOD_BEEP = "/pass.wav";
	public static final String ERROR_BEEP = "/error.wav"; 
	public static final int NO_BEEP = 0; 
	public static final int ONE_BEEP = 1; 
	public static final int TWO_BEEPS = 2; 
	public static final int THREE_BEEPS = 3; 
	public static final int FIVE_BEEPS = 5; 	
	
	// old stock Beeps 
	public static final Beeper sound1= new Beeper("/error.wav", ONE_BEEP);
	public static final Beeper sound2= new Beeper("/pass.wav", ONE_BEEP);	
	
	// Static members
	public static final int BEEP_WAIT_TIME_MS = 300;
	private boolean speakerEnabled; 
	
	// Instance Members
	private AudioClip clip;	
	private int numberOfBeeps; 	
	
	/**
	 * Constructor
	 */
	public Beeper() 
	{
		this(GOOD_BEEP, ONE_BEEP, true);
	}		
	
	/**
	 * Constructor
	 * @param numberOfBeeps the times the beeper beeps
	 */
	public Beeper(int numberOfBeeps)
	{
		this(GOOD_BEEP, numberOfBeeps, true); 
	}
	
	/**
	 * Constructor
	 * @param speakerEnabled speaker able to beep
	 */
	public Beeper(boolean speakerEnabled)
	{
		this(GOOD_BEEP, ONE_BEEP, false);
	}
	
	/**
	 * Constructor
	 * @param filename the sound file
	 * @param numberOfBeeps the number of beeps
	 */
	public Beeper(String filename, int numberOfBeeps)
	{
		this(filename, numberOfBeeps, true); 
	}
	
	/**
	 * Constructor
	 * @param filename the sound file
	 * @param numberOfBeeps the number of beeps
	 * @param speakerEnabled the speaker 
	 */
	public Beeper(String filename, int numberOfBeeps, boolean speakerEnabled)
	{
		try
		{
			clip = Applet.newAudioClip(Beeper.class.getResource(filename));
		}
		
		catch(Exception e)
		{
			System.out.println("Bad sound filename"); 
			e.printStackTrace();
		}
		
		this.numberOfBeeps = numberOfBeeps;  
		this.speakerEnabled = speakerEnabled;
	}
	
	/**
	 * The number of beeps
	 * @return the number of beeps
	 */
	public int getNumberOfBeeps()	
	{
		return numberOfBeeps; 
	}
	
	//Beep using TimerTask
	public void beep()
	{
		long delay = 0; 
		long period = (long) BEEP_WAIT_TIME_MS; 
		
		Timer beep = new Timer(); 
		beep.scheduleAtFixedRate(new TimerTask()
		{			
			int beepCount = 1; 
			
			public void run() 
			{
				if(speakerEnabled == true)
				{
					try
					{
						new Thread()
						{
							public void run()
							{
								clip.play();
							}
						}.start();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				
				if (beepCount++ == numberOfBeeps)
					this.cancel(); 
			}
			
		}, delay, period);
	}
}

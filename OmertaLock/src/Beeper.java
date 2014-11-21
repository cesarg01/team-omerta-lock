import java.applet.Applet;
import java.applet.AudioClip;
//import java.applet.Applet;

public class Beeper {
		
		boolean speakerEnabled = true;
		
		public static final Beeper sound1= new Beeper("/error.wav");
		public static final Beeper sound2= new Beeper("/pass.wav");
		private AudioClip clip;
		
		
	/**
	 * If user enters correct pin the speaker will be enabled/disabled
	 * depending on the speakers current state.
	 */
	public void toggleSpeaker()
	{
		
	}
	/*
	 * Enable speaker. 
	 */
	public void enableSpeaker()
	{
		speakerEnabled = true; 
	}
	
	/*
	 * Disable the speaker.
	 */
	public void disableSpeaker()
	{
		speakerEnabled = false;
	}
	
	public Beeper(String filename)
	{
		try
		{
			clip = Applet.newAudioClip(Beeper.class.getResource(filename));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void beep()
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
	}
}

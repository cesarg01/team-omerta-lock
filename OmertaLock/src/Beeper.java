import java.applet.Applet;
import java.applet.AudioClip;
//import java.applet.Applet;

public class Beeper {
		
		boolean speakerEnabled = false;
		
		public static final Beeper sound1= new Beeper("/error.wav");
		public static final Beeper sound2= new Beeper("/pass.wav");
		private AudioClip clip;
		
		
	public void enableSpeaker()
	{
		speakerEnabled = true; 
	}
	
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

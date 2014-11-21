import java.applet.Applet;
import java.applet.AudioClip;
//import java.applet.Applet;

public class Sound {

		public static final Sound sound1= new Sound("/error.wav");
		public static final Sound sound2= new Sound("/pass.wav");
		
		private AudioClip clip;
	public Sound(String filename)
	{
		try
		{
			clip = Applet.newAudioClip(Sound.class.getResource(filename));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void play()
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

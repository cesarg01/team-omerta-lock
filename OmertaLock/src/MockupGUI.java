import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MockupGUI
{
	private JFrame frame;
	
	public static void main(String[] args)
	{
		MockupGUI keypad = new MockupGUI();
		keypad.initialSetUp();
	}
	
	private void initialSetUp()
	{
		frame = new JFrame("Omerta Electronic System Mockup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4,3));
		
		// Start adding the buttons
	    frame.add(new JButton("1"));
	    frame.add(new JButton("2"));
	    frame.add(new JButton("3"));
	    frame.add(new JButton("4"));
	    frame.add(new JButton("5"));
	    frame.add(new JButton("6"));
	    frame.add(new JButton("7"));
	    frame.add(new JButton("8"));
	    frame.add(new JButton("9"));
	    frame.add(new JButton("*"));
	    frame.add(new JButton("0"));
	    frame.add(new JButton("#"));
	    frame.pack();
	    frame.setVisible(true);
	}
}

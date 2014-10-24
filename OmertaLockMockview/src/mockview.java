import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class mockview extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton a[] = new JButton[13]; // Array of Buttons
	public mockview(){
		super("Omerta Electronix Mockview");
		setSize(600,400); // Window Size
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15,15,15,15);
		for(int i = 0 ; i < 13 ; i++)
		{
			a[i] = new JButton("" + i); 
			gbc.gridy = i;
			p.add(a[i]);	// add to JPanel p
		}

		add(p); // add JPanel p to JFrame
	}
}

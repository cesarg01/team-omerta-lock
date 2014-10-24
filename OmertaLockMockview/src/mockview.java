import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class mockview extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int KEY_SIZE = 12;
	JButton a[] = new JButton[KEY_SIZE]; // Array of Buttons
	
	public mockview(){
		super("Keyboard");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,3)); //4 Rows/3 Columns
		
		for(int i = 0 ; i < KEY_SIZE ; i++)
		{
		
			if(i == 10) // Tenth item is the asterisk
			{
				a[i] = new JButton("*");
				p.add(a[i]);	// add to JPanel p

			}
			else if(i == 11) // Eleventh item is the aterik
			{
				a[i] = new JButton("#");
				p.add(a[i]);	// add to JPanel p

			}
			 
			 else
			 {
				 a[i] = new JButton("" + i); 
				 p.add(a[i]);	// add to JPanel p
			 }

		}
		
		add(p);	 	// add JPanel p to JFrame
		pack(); 	// tight components
		
a[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Thanks 4 Clic");

			}
		});
	}
}

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;


public class LockPanel extends JPanel
{
	final JButton one = new JButton("1"); 
	final JButton four = new JButton("4"); 
	final JButton seven = new JButton("7"); 
	final JButton star = new JButton("*"); 

	final JButton two = new JButton("2"); 
	final JButton five = new JButton("5"); 
	final JButton eight = new JButton("8"); 
	final JButton zero = new JButton("0"); 
	final JButton omerta = new JButton("Omerta"); 

	final JButton three = new JButton("3"); 
	final JButton six = new JButton("6"); 
	final JButton nine = new JButton("9"); 
	final JButton pound = new JButton("#"); 
	
	private EventListenerList listenerList = new EventListenerList(); 
	
	public LockPanel()
	{
		Dimension size = getPreferredSize();
		size.width = 270; 
		setPreferredSize(size); 
		setLayout(new GridBagLayout()); 
		
		// components (buttons and labels)
		JLabel greenled = new JLabel(); 
		greenled.setIcon(new ImageIcon("res/greenledOFF.png"));

		JLabel redled = new JLabel(); 
		redled.setIcon(new ImageIcon("res/redledOFF.png")); 

		JLabel speakerholes = new JLabel(); 
		speakerholes.setIcon(new ImageIcon("res/speakerHoles.png")); 

		////////Position the components on the Panel ////////////////////		
		GridBagConstraints gc = new GridBagConstraints(); 
		
		/////// First column ////////////////////////
		gc.weightx = 0.5; 
		gc.weighty = 0.5; 
		
		gc.gridx = 0; 
		gc.gridy = 0; 
		gc.anchor = GridBagConstraints.LINE_END; 
		add(greenled, gc); 
		gc.anchor = GridBagConstraints.CENTER;
		
		
		gc.gridx = 0; 
		gc.gridy = 1; 
		gc.gridwidth = 3; 
		add(speakerholes, gc);
		gc.gridwidth = 1; 
		
		gc.gridx = 0; 
		gc.gridy = 2; 		 
		add(one, gc); 
		
		gc.gridx = 0; 
		gc.gridy = 3; 
		add(four, gc); 
		
		gc.gridx = 0; 
		gc.gridy = 4; 
		add(seven, gc); 
		
		gc.gridx = 0; 
		gc.gridy = 5; 
		add(star, gc); 
		
		gc.gridx = 0; 
		gc.gridy = 6;
		gc.gridwidth = 3;
		add(omerta, gc);
		gc.gridwidth = 1;
		
		////// Second column //////////////////////////		
		gc.gridx = 1; 
		gc.gridy = 2;
		gc.gridwidth = 1; 
		add(two, gc);
		
		gc.gridx = 1; 
		gc.gridy = 3; 
		add(five, gc);
		
		gc.gridx = 1; 
		gc.gridy = 4; 
		add(eight, gc);
		
		gc.gridx = 1; 
		gc.gridy = 5; 
		add(zero, gc); 
		
		
		////// Third Column ///////////////////////////
		gc.gridx = 2; 
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(redled, gc); 
		gc.anchor = GridBagConstraints.CENTER;
		
		gc.gridx = 2; 
		gc.gridy = 2;		
		add(three, gc); 
		
		gc.gridx = 2; 
		gc.gridy = 3;		
		add(six, gc);
		
		gc.gridx = 2; 
		gc.gridy = 4;		
		add(nine, gc);
		
		gc.gridx = 2; 
		gc.gridy = 5;		
		add(pound, gc);
		
		////// Add action listeners to each button /////////////////////
		one.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = one.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		two.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = two.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		three.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = three.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		four.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = four.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		five.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = five.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		six.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = six.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		seven.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = seven.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		eight.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = eight.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		nine.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = nine.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		zero.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = zero.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		star.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String id = star.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		pound.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String id = pound.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
		
		omerta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Beeper.keyPress.beep();
				String id = omerta.getText(); 
				fireInputEvent(new InputEvent(this, id)); 
				//System.out.println(id); 
			}			
		});
	}
	
	public void fireInputEvent(InputEvent e)
	{
		Object[] listeners = listenerList.getListenerList(); 
		
		for (int i = 0; i < listeners.length; i += 2)
		{
			if(listeners[i] == InputListener.class)
			{
				( (InputListener)listeners[i+1] ).inputEventOccurred(e); 
			}
		}
	}
	
	public void addInputListener(InputListener listener)
	{
		listenerList.add(InputListener.class, listener); 
	}	
}

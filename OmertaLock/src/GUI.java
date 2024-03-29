//---------------------------------------------------------

// Project Keypad
// Class MyFrame
    
// Enter digits in a textfield with
// Buttons on a keypad.
    
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;


public class GUI extends JFrame
{
	
	public static void main(String[] args)
	{
		GUI gui = new GUI();
	}
	
	String sampleKey;
	private Beeper sound;
	private PIN_List list = new PIN_List();
	private Lock lock = new Lock();
	private PIN pin;
	private static final int PIN_LENGTH = 4;
	
    private static final int FRAME_WIDTH  = 245;
    
    /////////////////////HEIGHT for LED suggestion////////////////////////////
    // Can make the height 540 to add the LED on the bottom.
    private static final int FRAME_HEIGHT = 640;
    private static final int BUTTON_WIDTH = 50;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_Y = 260;
    
    
	  
    JButton[] key;			// ARRAY OF KEYS/BUTTONS
    JLabel greenLED; 
    JLabel redLED;         
    JButton reset;			// RESET BUTTON
    JTextField display;		// TEXT DISPLAY
    JPanel panel;			// JPANEL...SO OBVIOUS.
    
    
    
    //@SuppressWarnings("deprecation")
	public GUI()
    {
        // Set title in title bar.
        super("Omerta Electronic System");
        
        // Local variables.
        int row, col, i;
        
        // sound = new Sound("sound");
        // Create array of keys.
        key = new JButton[12];
        
        // Create and configure panel.
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        
        // Create ActionListener for keys.
        KeyDetect keyAL = new KeyDetect();
        ValidateInput valPut = new ValidateInput();
        
        // Create and position individual 
        // keys with numbers 1 through 9.
        for(i = 0; i <= 9; i++)
        {
        	
            key[i] = new JButton(String.valueOf(i));
            panel.add(key[i]);
            row = (i - 1) / 3;
            col = (i - 1) % 3;
            key[i].setBounds(20+70*col, 50+70*row, BUTTON_WIDTH, BUTTON_HEIGHT);
            key[i].addActionListener(keyAL);
        }
        
        // Create and position button 0.
        key[0] = new JButton("0");
        panel.add(key[0]);
        key[0].setBounds(20+70*1, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        key[0].addActionListener(keyAL);
        
     // Create and position button *.
        key[10] = new JButton("*");
        panel.add(key[10]);
        key[10].setBounds(20, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        key[10].addActionListener(keyAL);
        
     // Create and position button #.
        key[11] = new JButton("#");
        panel.add(key[11]);
        key[11].setBounds( 160, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        key[11].addActionListener(keyAL);
        key[11].addActionListener(valPut);
       
       
        // Create and configure reset button.
        reset = new JButton("Omerta");
        panel.add(reset);
        reset.setBounds(20, 330, 190, BUTTON_HEIGHT);
        reset.addActionListener(new ResetDetect());
        
        // Create and configure textfield.
        display = new JTextField(1);
        panel.add(display);
        display.setBounds(20, 10, 190, 20);
        display.setEditable(false);
        
        ///////// HAVING ISSUES WITH DISPLAYING THE IMAGE //////////////////
        ImageIcon greenOFF = new ImageIcon("/greenledOFF.png");
        greenLED = new JLabel(greenOFF);
        greenLED.setIcon(greenOFF);
        greenLED.setBounds(220, 600, 40, 50);
        panel.add(greenLED);
        greenLED.repaint();
        
        // Set size and show the frame.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);     
        
        // Set pin length
        //pin.setPinLength(PIN_LENGTH);
        
    }
    
    private class KeyDetect implements ActionListener
    {
    	
        // When a button is clicked, append the digit
        // in the caption of the button to the digits
        // in the textfield.
        
        // Note: the reference e.getSource must be cast
        // to a JButton to be able to get its text.
        public void actionPerformed(ActionEvent e)
        {

            String s;
            
            if(display.getText().length() < PIN_LENGTH)
            {
                s = display.getText();
                s += ((JButton) e.getSource()).getText();
                display.setText(s);
                
            }
        }
    }
    
    private class ResetDetect implements ActionListener
    {
        // Clear the textfield.
        public void actionPerformed(ActionEvent e)
        {
            display.setText("");
        }
    }
    
    private class ValidateInput implements ActionListener
    {
    	//Clip clip = AudioSystem.getClip();
    	//AudioInputStream audioIn = AudioSystem.getAudioInputStream(Main.class.getResource("error.wav"));
    	//clip.open(audioIn);
    	//clip.start();
    	
    	public void actionPerformed(ActionEvent e)
    	{
    		int pinNum;
    		String s = display.getText();
    		 // PIN
            pinNum = Integer.parseInt(s);
            pin = new PIN(pinNum);
            list.insert(pin);            
            
    		if(list.contains(pinNum) == true)//display.getText().equals("1357"))
    		{
    			Beeper.sound2.beep();
    			JOptionPane.showMessageDialog(null, "You got the password");
    			
//////////////////// TESTING OF REMOVE /////////////////////////////////////
    			list.remove(pin);
    			s = display.getText();
        		 // PIN
    			JOptionPane.showMessageDialog(null, "Enter New PIN");
                pinNum = Integer.parseInt(s);
                pin = new PIN(pinNum);
                list.insert(pin);
    			pin = new PIN(pinNum);
    			list.insert(pin);

}
    		
    		else
    		{
    
    			Beeper.sound1.beep();
        		JOptionPane.showMessageDialog(null, "You suck balls");

    		}
    		if(list.contains(pinNum) == true)
    		{
    			JOptionPane.showMessageDialog(null, pinNum);
    			JOptionPane.showMessageDialog(null, "You got it?");
    		}
   
    		
            display.setText("");


    	}
    }
    
}


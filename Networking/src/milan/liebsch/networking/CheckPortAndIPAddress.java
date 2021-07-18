package milan.liebsch.networking;


import java.awt.BorderLayout;
import java.awt.Button;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import milan.liebsch.mycomponents.*;

public class CheckPortAndIPAddress extends JFrame {
	// the serialVersionUID is used on deserialization to verify if the data is valid
	private static final long serialVersionUID = 1L;

	// new text area with 6 rows and 25 columns (25 columns means the width will be 25 characters wide)
	public JTextArea infoArea = new JTextArea(6, 25);
	
	// constructor
	public CheckPortAndIPAddress() {
		// own method for gui initialization
		initGUI();
		// sets the title of this frame
		setTitle("Check Port and IP Address");
		// the pack method sizes the frame so that all its contents are at or above thier preferred sizes
		pack();
		// sets the location of the frame relative to a component, if null the location is set relative to the center
		setLocationRelativeTo(null);
		// we need to set the Frame visible
		setVisible(true);
		// exit on close is a good idea
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void initGUI() {
		// adds the infoArea to the GUI container
		add(infoArea, BorderLayout.CENTER);	
	}


	public static void main(String[] args) {
		try {
			
			// get className of PlatformLookAndFell class
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			// sets look and feel to the CrossPlatformLookAndFeelClass
			UIManager.setLookAndFeel(className);
		}
		catch(Exception e) {
			// nothing todo
		}
		
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new CheckPortAndIPAddress();
			}
		});
	
		CheckPortAndIPAddress test = new CheckPortAndIPAddress();

	}

}

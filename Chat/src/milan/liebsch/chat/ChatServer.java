package milan.liebsch.chat;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

import milan.liebsch.mycomponents.TitleLabel;

public class ChatServer extends JFrame {
	private static final long serialVersionuID = 1L;
	
	public ChatServer() {
		// own method for gui initialization
		initGUI();
		// sets the title of this frame
		setTitle("Chat Server");
		// the pack method sizes the frame so that all its contents are at or above thier preferred sizes
		pack();
		// sets the location of the frame relative to a component, if null the location is set relative to the center
		setLocationRelativeTo(null);
		// we need to set the Frame visible
		setVisible(true);	
	}
	

	private void initGUI() {
		// new instance of a titleLabel we want to use
		TitleLabel titleLabel = new TitleLabel("Chat Server");
		// add our new titleLable to the GUI 
		add(titleLabel, BorderLayout.BEFORE_FIRST_LINE);
	}



	public static void main(String[] args) {
		try {
			// find out the look and feel of the crossplatform
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			// set the look and feel of the crossplatform for the program gui
			UIManager.setLookAndFeel(className);
		}
		catch(Exception e) {
			// nothing todo until now
		}
		ChatServer test = new ChatServer();
	}

}

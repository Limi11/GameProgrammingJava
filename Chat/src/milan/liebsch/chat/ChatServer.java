package milan.liebsch.chat;

import javax.swing.JFrame;

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
		TitleLabel titleLabel = new TitleLabel("Chat Server");
		
	}



	public static void main(String[] args) {
		ChatServer test = new ChatServer();
	}

}

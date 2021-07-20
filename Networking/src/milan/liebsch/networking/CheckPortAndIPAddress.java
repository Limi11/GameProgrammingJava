package milan.liebsch.networking;


import java.awt.BorderLayout;
import java.awt.Button;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import milan.liebsch.networking.*;

public class CheckPortAndIPAddress extends JFrame {
	// the serialVersionUID is used on deserialization to verify if the data is valid
	private static final long serialVersionUID = 1L;

	// new text area with 6 rows and 25 columns (25 columns means the width will be 25 characters wide)
	public JTextArea infoArea = new JTextArea(6, 25);
	
	// InetAddress object is used to get the IP address of the local host
	private InetAddress host; 
	
	// attribute for local hostname
	private String hostname;
	
	// attribute for local IPAddress
	private String privateIPAddress; 
	
	// attribute for the port number
	private int port;
	
	// attribute for url address
	private URL url;
	
	// 
	private BufferedReader in;
	
	//
	private String publicIPAddress;
	
	
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
		// get port number
		// creating a server socket at port 0 connects to a random available port
		try {
			// init a new ServerSocket object with free random port
			ServerSocket serverSocket = new ServerSocket(0);
			// save the chosen port number into the port attribute
			this.port = serverSocket.getLocalPort();
			// class InetAddress is used to get local host InetAddress object
			this.host = InetAddress.getLocalHost();
			// use InetAddress object host to get the local hostname
			this.hostname = this.host.getHostName();
			// use InetAddress object host to get the local IPAddress
			this.privateIPAddress = this.host.getHostAddress();
			// instantiate url object with address http://checkip.amazonaws.com/ to check public ip address
			this.url = new URL("http://checkip.amazonaws.com/");
			// instantiate bufferedreader object "in" using an inputstream reader object created by opening a stream to url
			this.in = new BufferedReader(new InputStreamReader(this.url.openStream()));
			// read input stream into string publicIPAddress
			this.publicIPAddress = in.readLine();
			// print port, hostname and privateIPAddress into the infoArea
			infoArea.setText("Port: " + this.port + "\n" + "Hostname: " + this.hostname + "\n" + "Private IPAddress: " + this.privateIPAddress + "\n" + "Public IPAddress: " + this.publicIPAddress);
			// don't forgett to close the server socket!
			serverSocket.close();
		}
		catch(Exception e) {
			infoArea.setText(e.getMessage());
		}
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
		
		// The Swing library and AWT (abstract window toolkit) is not threadsave and all it methods should run on the Event Dispatch Thread (EDT)
		// with with the SwingUtilities.invokeLater(...) function we pass a runnable to the  Event Dispatch Thread (EDT) where these applications should run on
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				// we wand to run the CheckPortAndIPAddress class constructor on the EDT
				new CheckPortAndIPAddress();
			}
		});

	}

}

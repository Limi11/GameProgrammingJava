package milan.liebsch.hitcounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HitCounter {
	
	// we need the port number of the server socket
	private static final int PORT_NUMBER = 63457;
	
	// the socket is an object which serves as a common point for data communication between a server an a client
	private Socket socket;
	
	
	public HitCounter() {
		// there could be an IOException whe we instanciate a socket
		try {
			// generate an instance of a Socket for computer internal communication via localhost and port number
			// for test we only use localhost, later on we could use an ip adress of another computer in internal 
			// network, or use the public IP by using port forwarding
			socket = new Socket("localhost", PORT_NUMBER);
			// there could be an IOException when insanciating and using an inputstream
			try {
				// we need a bufferedreader to receive the inputstream
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// read a line of the inputstream and save it in answer string
				String answer = in.readLine();
				// print answer
				System.out.println(answer);
			}
			// catch the  catch the IOException and print out a understandable error message on the console
			catch (IOException e){
				System.out.println("IOExcepton was caught when trying to start a new BufferedReader for the InputStream!");
				e.printStackTrace();
			}
		 
		}
		// catch the IOException and print out a understandable error message on the console
		catch (IOException e) {
			System.out.println("IOExcepton was caught when trying to connect with localhost with PORT_NUMBER: " + PORT_NUMBER);
			e.printStackTrace();
		}
		// finally wer close the socket to free up resources, all streams and buffered readers and -writers used by the socket are automatically closed
		finally {
			try {
				if(socket != null) {
					socket.close();
				}
			}
			catch (IOException e) {
				// we just want to finisch and don't need to handle a acception here
			}
			}
	}
			
	public static void main(String[] args) {
		HitCounter hitcounter = new HitCounter();
	}

}

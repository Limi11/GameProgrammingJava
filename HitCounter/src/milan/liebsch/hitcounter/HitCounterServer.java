package milan.liebsch.hitcounter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// HitCounterServer class is used to communicate with clients and counts the amount of connections
public class HitCounterServer {
	
	// we need a port number to open a new socket, ports 1 to 256 are reserved, ports less than 1024 need root access, choose port from 1025-65535
	private static final int PORT_NUMBER = 63457;
	
	// the serversocket listens for incoming client messages and opens a socket for communication
	private ServerSocket serverSocket;
	
	// the socket is an object which serves as a common point for data communication between a server an a client
	private Socket socket;
	
	// variable for counting server client connections
	private Integer count = 0;
	
	// constructor of class hitcounterserver
	public HitCounterServer() {
		// information that the server is running on console
		System.out.println("Server is running!");
		// we need to handle IOExceptions
		try {
			// a server socket listens on an assigned port for any incoming massages
			serverSocket = new ServerSocket(PORT_NUMBER);
			// endless while loop to get more clients connected
			while(true) {
				// the server socket opens a socked to the origin of the received message
				socket = serverSocket.accept();
				// information that the server has accepted the client and opened a socket
				System.out.println("Socket accepted!");
				// new printwriter for communication with client, we need outoflush that the stream will be written out!
				PrintWriter toClient = new PrintWriter(socket.getOutputStream(), true);
				// count up the number of clients
				count++;
				// send the client the current amount of client server connections
				toClient.println(count);
			}
		}
		// if we catch an IOException we give an error message on console output
		catch (IOException e) {
			System.out.println("Excepton was caught when trying to listen on PORT_NUMBER: " + PORT_NUMBER);
			e.printStackTrace();
		}
		// finally wer close the serversocket and the socket to free up resources, all streams and buffered readers and -writers used by the socket are automatically closed
		finally {
			System.out.println("Server is stopped!");
			try {
				if(serverSocket != null && serverSocket.isClosed() != true) {
					serverSocket.close();
				}
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
		// we generate an insatnce of HitCounterServer for communication with clients
		HitCounterServer server = new HitCounterServer();
	}

}

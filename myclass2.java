import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class myclass2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		encydecy_server();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int encydecy_server()
	{

		ServerSocket socketfd = null;
	    int line;
	    DataInputStream is;
	    DataOutputStream os;
	    Socket clientSocket = null;
	    
	 // Try to open a server socket on port 4000

	    try {
	        socketfd = new ServerSocket(4000);
	        System.out.println("Server started");
	        
	        System.out.println("Waiting for a client ...");
	     }
	     catch (IOException e) {
	        System.out.println(e);
	     }   
	 // Create a socket object from the ServerSocket to listen and accept 
	 // connections.
	 // Open input and output streams
	    
	    while(true)
	    {
	     try {
	            clientSocket = socketfd.accept();
	            System.out.println("\n Client accepted in encrypetion decryption server");
	          

	     }
	     catch (IOException e) {
	         System.out.println(e);
	      }
	     try
	     {
	     new CThread(clientSocket).start();
	  
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	    }
	}
}

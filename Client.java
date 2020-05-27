
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.net.*;

public class Client {
	

	public static void main(String[] args)
	{
		try
		{
			
		
			while(true){
				
				main_menu(args);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
	}
	static int fortune_cookie1() 
	{
		
	 try
	 {
		Socket socket = null;
	    DataInputStream  is = null;
	    DataOutputStream os = null;
	    PrintWriter pw= null;
	    BufferedReader br = null;
	    
	 // Initialization section:
	 		 // Try to open a socket on port 8888
	 		 // Try to open input and output streams
	    
	 		         try {
	 		             socket = new Socket("localhost", 8888);
	 		        	//socket = new Socket("172.29.125.66", 8888);
	 		             os = new DataOutputStream(socket.getOutputStream());
	 		             is = new DataInputStream(socket.getInputStream());
	 		            
	 		            pw = new PrintWriter(socket.getOutputStream(),true);
	 		           
	 					br =new BufferedReader( new InputStreamReader(socket.getInputStream()));
	 					
	 		         } catch (UnknownHostException e) {
	 		             System.err.println("Don't know about host: hostname");
	 		         } catch (IOException e) {
	 		        	 e.printStackTrace();
	 		             //System.err.println("Couldn't get I/O for the connection to: hostname");
	 		         }
	 		      
	 		          if (socket != null && os != null && is != null) 
	 		          {
	 		                  try {
	 		     
	 		                	  System.out.println("enter number of cookies");
	 		                	  Scanner scan = new Scanner(System.in);
	 		                	  int cookie= scan.nextInt();
	 		                	  pw.println(cookie);
	 		                	  //System.out.println("Number of cookies entered by client:" + cookie);
	 		                	  for(int i=1;i<=cookie+3;i++)
	 		                	  {
	 		                			  
	 		                	  String reply_cooki = br.readLine();
	 		                	  System.out.println(reply_cooki);
	 		                	  }
	 		                	  
	 		                  }
	 		                  catch (Exception e) {
	 		                      System.err.println("error in getting number of cookie or reading number of cookies from server: " + e);
	 		                  } 
	}
	 }
	 catch(Exception e)
		{
			System.out.println("Client error:"+e.getMessage());
		}
	 return 0;
	 
	
	}
	
	static int encydecy_client() 
	{
		
	    
	    
		String[] message = new String[100];
		
		Socket socket = null;
		DataInputStream  is = null;
	    DataOutputStream os = null;
	   // ObjectOutputStream out = null;
	    //ObjectInputStream in = null;
	    BufferedReader stdIn = null;
	    PrintWriter pw= null;
	    BufferedReader br = null;
	    BufferedReader br2 = null;
	    
	 // Initialization section:
	 		 // Try to open a socket on port 4000
	 		 // Try to open input and output streams
	    
	 		         try {
	 		             socket = new Socket("localhost",4000);
	 		            //socket = new Socket("172.29.125.66",4000);
	 		             os = new DataOutputStream(socket.getOutputStream());
	 		             is = new DataInputStream(socket.getInputStream());
	 		             //out = new ObjectOutputStream(socket.getOutputStream());
	 		             //in = new ObjectInputStream(socket.getInputStream());
	 		            stdIn =new BufferedReader(new InputStreamReader(System.in));
	 		         pw = new PrintWriter(socket.getOutputStream(),true); 
	 		         
	 		         		try {
	 					       br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
	 				            } 
	 		         		catch (IOException e1) {
	 		         			e1.printStackTrace(); }
	 		         		
	 		                try {
	 					     br2 =new BufferedReader(new InputStreamReader(socket.getInputStream()));
	 				          } catch (IOException e1) {
	 					         e1.printStackTrace();  }
	 		                
	 		         } 
	 		         catch (UnknownHostException e) {
	 		             System.err.println("Don't know about host: hostname");
	 		         } 
	 		         catch (IOException e) {
	 		        	e.printStackTrace();
	 		         }


		 	if (socket != null && os != null && is != null && stdIn !=null && pw !=null ) 
		     {
		 		 try {
		 		      
		 			 	//keep communicating with server
		 			 	while(true)
		 			 	{
		 			 		System.out.println("Enter line to encrypt or decrypt");
	    	
		 			 		Scanner scan= new Scanner(System.in);
			
		 			 		String input;
		 			 		input = stdIn.readLine();
		 			 		System.out.println(input);
		 			 		System.out.println("\n enter 1 for encryption");
		 			 		System.out.println("\n enter 2 for decryption");
		 			 		System.out.println("\n enter 3 for exit from this server");
	        
	        
		 			 		int d= scan.nextInt();
		 			 		switch(d)
		 			 		{
		 			 		case 1:
		 			 			//System.out.println("case 1");
		 			 			input = input.concat("1");
		 			 			pw.println(input);
		 			 			//System.out.println("Again case 1");
		 			 			char[] aarv= new char[2000];
		 			 			br.read(aarv);
					
		 			 			// out.writeObject(message);
				    
				    
		 			 			System.out.println("Replay from server");
		 			 			System.out.println(aarv);
		 			 			break;
		 			 			case 2:
		 			 				//System.out.println("case 2");
		 			 				input = input.concat("0");
		 			 				pw.println(input);
		 			 				//System.out.println("Again case 0");
		 			 				char[] aarv2= new char[2000];
		 			 				br2.read(aarv2);
		 			 				System.out.println("Replay from server");
		 			 				System.out.println(aarv2);
		 			 				break;
		 			 			case 3:
		 			 				System.out.println("case 3");
		 			 				//System.exit(0);
		 			 				return 0;
			
		 			 		}
		 
		 			 	}
		 		
		 		 }
		catch(Exception e)
		 		   {
		 		        System.out.println("Error");
		 		    }
		   }
		 return 0;
  }
	
static	void main_menu(String[] args)
	{
	
	
		char ch;
		while(true)
		{
	    System.out.println("\n*************************************************\n");
	    System.out.println("Select any one of the options below");
	    System.out.println("\n*************************************************\n");
	    System.out.println("\na) interact with the Fortune Cookie Server\nb) interact with the encryption/decryption server\nc) quit\n");
	    System.out.println("\n*************************************************\n\n");
	    Scanner scan = new Scanner(System.in);
	    ch= scan.next().charAt(0);
	    
	    if(Character.isUpperCase(ch))
	    {
	    	ch= Character.toLowerCase(ch);
	    }
			switch (ch) {
	        case 'a':
	        fortune_cookie1();
	        break;
	        case 'b':
	        encydecy_client();
	        break;
	        case 'c':
			System.exit(0);
	        	//return 0;
	        break;
	        default :
            System.out.println("\nPlease enter either a or b or c.\n");
	        break;
	    }
		}
		
	}
	
	
}
		 
		

		

	

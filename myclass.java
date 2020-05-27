import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;


public class myclass extends Thread {

	@Override
	public void run() {
		
		 //int[] fortuneBuff;
		fortune_server();
		
		

	}

	public static void main(String[] args) {
	}
		

	
	@SuppressWarnings("null")
	static int fortune_server()
	{
		
		 ServerSocket socketfd = null;
	     int line;
	     DataInputStream is;
	     DataOutputStream os;
	     BufferedReader br = null;
	     PrintWriter pw= null;
	     Socket clientSocket = null;
	     Socket temp = null;
	    //int[] fortuneBuff = null;
	     int rv = 0;
	     
	  // Try to open a server socket on port 8888
	  
	     try {
	    	 
	         socketfd = new ServerSocket(8888);
	         
			
	         System.out.println("Server started");
	         
	         System.out.println("Waiting for a client ...");
	      }
	      catch (IOException e) {
	         System.out.println(e);
	      }   
	     
	  // Create a socket object from the ServerSocket to listen and accept 
	  // connections.
	  // Open input and output streams
	     
	      try {
	             
	    	  //for(int j=0;j<5;j++)
	    	  //{
	    	          temp = socketfd.accept();
	    			  clientSocket = temp;
	    	  //clientSocket = socketfd.accept();
	           while(clientSocket != null)
	           //while(true)
	           {
	        	   //clientSocket = socketfd.accept();
	             System.out.println("\n Client accepted in fortune server");
	             is = new DataInputStream(clientSocket.getInputStream());
	             os = new DataOutputStream(clientSocket.getOutputStream());
	             
	 			 br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	 			 pw = new PrintWriter(clientSocket.getOutputStream(),true);


	             Scanner scan = new Scanner(System.in);
	             
	               rv = Integer.parseInt(br.readLine());
	               if (rv != 0)
	               {
	            	  // while(true)
	            	   //{
	              
	               System.out.println("Number of cookies from client is:");
	               System.out.println(rv); 
	               
	               for (int i=0; i<rv; i++)
	               {
	            	  
	            		   Random dex = new Random();
	            		   int r = dex.nextInt(54) + 1 ;
	            		   //System.out.println(r);
	            		   
	            		   String fortunes = fortuneFun(r);
	            		   System.out.println(fortunes);
	            		   //System.out.println("sent");
	            		   //fortuneBuff[r] = r;
	            		   pw.println(fortunes);
	            		   pw.flush();
	            		  
	            		
	            		
	            		   
	               }
	              
	            }
	               else
	               {
	            	   System.out.println("client is disconncted from fortune server");
	               }
	             
	             
	               
	               clientSocket = null;
	             //}
	           }
	           //clientSocket.close();
	           
	      }
	     
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	     
	      
	      return 0;
		
	}


	static String fortuneFun(int index)
	{
		String fortunes[] =
			{
				"Adventure can be real happiness.\n",
		        "Advice is like kissing. It costs nothing and is a pleasant thing to do.\n",
		        "Advice, when most needed, is least heeded.\n",
		        "All your hard work will soon pay off.\n",
		        "Allow compassion to guide your decisions.\n",
		        "An agreeable romance might begin to take on the appearance.\n",
		        "An important person will offer you support.\n",
		        "An inch of time is an inch of gold.\n",
		        "Any decision you have to make tomorrow is a good decision.\n",
		        "At the touch of love, everyone becomes a poet.\n",
		        "Be careful or you could fall for some tricks today.\n",
		        "Beauty in its various forms appeals to you.\n",
		        "Because you demand more from yourself, others respect you deeply.\n",
		        "Believe in yourself and others will too.\n",
		        "Believe it can be done.\n",
		        "Better ask twice than lose yourself once.\n",
		        "Carve your name on your heart and not on marble.\n",
		        "Change is happening in your life, so go with the flow!\n",
		        "Competence like yours is underrated.\n",
		        "Congratulations! You are on your way.\n",
		        "Could I get some directions to your heart?\n",
		        "Courtesy begins in the home.\n",
		        "Courtesy is contagious.\n",
		        "Don’t confuse recklessness with confidence.\n",
		        "Don’t just spend time. Invest it.\n",
		        "Don’t just think, act!\n",
		        "Don’t let friends impose on you, work calmly and silently.\n",
		        "Don’t let your limitations overshadow your talents.\n",
		        "Don’t worry; prosperity will knock on your door soon.\n",
		        "Each day, compel yourself to do something you would rather not do.\n",
		        "Education is the ability to meet life’s situations.\n",
		        "Emulate what you admire in your parents.\n",
		        "Emulate what you respect in your friends.\n",
		        "Every flower blooms in its own sweet time.\n",
		        "Everyday in your life is a special occasion.\n",
		        "Failure is the chance to do better next time.\n",
		        "Fear and desire — two sides of the same coin.\n",
		        "Feeding a cow with roses does not get extra appreciation.\n",
		        "For hate is never conquered by hate. Hate is conquered by love.\n",
		        "Fortune Not Found: Abort, Retry, Ignore?\n",
		        "From listening comes wisdom and from speaking repentance.\n",
		        "From now on your kindness will lead you to success.\n",
		        "Get your mind set — confidence will lead you on.\n",
		        "Get your mind set…confidence will lead you on.\n",
		        "Go take a rest; you deserve it.\n",
		        "Good news will be brought to you by mail.\n",
		        "Good news will come to you by mail.\n",
		        "Good to begin well, better to end well.\n",
		        "Happiness begins with facing life with a smile and a wink.\n",
		        "Happiness will bring you good luck.\n",
		        "Happy life is just in front of you.\n",
		        "Hard words break no bones, fine words butter no parsnips.\n",
		        "Have a beautiful day.",                                                                 
		        "Show everyone what you can do.\n", 
		        "Respect your elders. You could inherit a large sum of money.\n", 
		        "Move quickly. Now is the time to make progress.\n" 
			};
		return fortunes[index];
	}
	
	
}

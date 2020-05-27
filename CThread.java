import java.io.IOException;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.net.*;



public class CThread extends Thread
{

	
		
		protected Socket soc;
		DataInputStream is;
	    DataOutputStream os;
	    ObjectOutputStream out = null;
	    ObjectInputStream in = null;
	    BufferedReader br = null;
	    PrintWriter pw= null;
	    PrintWriter pw1= null;
	    String line;
	    String send;
	    char[] tt =new char[2000];
	    
		public CThread(Socket clientSocket)
		{
			this.soc = clientSocket; 
		}
		
		public void run()
		{
			 
			System.out.println("\n New thread assigned to attain encryption decryption client");
			
				try {
					is = new DataInputStream(soc.getInputStream());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			    try {
					os = new DataOutputStream(soc.getOutputStream());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			   /* try {
					out = new ObjectOutputStream(soc.getOutputStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    try {
					in = new ObjectInputStream(soc.getInputStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			   try {
				br =new BufferedReader( new InputStreamReader(soc.getInputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			   
			   try {
				pw = new PrintWriter(soc.getOutputStream(),true);
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			    
			   try {
					pw1 = new PrintWriter(soc.getOutputStream(),true);
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			
			while(true)
			{
				try
				{
					
					
					line = br.readLine();
					if(line != null)
					{
					//System.out.println("mesaage from client is : ");
					//System.out.println(line);
					int size= line.length();
					char fg= line.charAt(size-1);
					String reply= line.substring(0,size-1);
					System.out.println("message from client:" + reply);
					//System.out.println(reply);
					char ch;
					int key= 4;
					if(fg == '1')
					{
						//System.out.println("\n loop in fg1");
						for(int i=0;i<size-1;i++)
						{
							ch = reply.charAt(i);
							if(!(Character.isAlphabetic(ch)))
							{
								continue;
							}
							if(Character.isUpperCase(ch))
							{
								ch=(char) (((ch-'A')+ 4) % 26 + 'A'); 
							}
							else
							{
							if(Character.isLowerCase(ch))
							{
								ch = (char) (((ch - 'a') + 4) % 26 + 'a');
							}
							}
							tt[i]= ch;
							//System.out.println(tt[i]);
							
						}
						
						pw.println(tt);
					}
					else
					{
						//System.out.println("\n loop in fg0");
						for(int i=0;i<size-1;i++)
						{
							ch = reply.charAt(i);
							if(!(Character.isAlphabetic(ch)))
							{
								continue;
							}
							if(Character.isUpperCase(ch))
							{
								ch=(char) (((ch-'Z')- 4) % 26 + 'Z'); 
							}
							else
							{
							if(Character.isLowerCase(ch))
							{
								ch = (char) (((ch - 'z') -4 ) % 26 + 'z');
							}
							}
							tt[i]= ch;
							//System.out.println(tt[i]);
							
						}
						//System.out.println(tt);
						pw1.println(tt);
					}
					
					
					}
					else
					{
						System.out.println("client disconncted from encryption decryption servere");
					}
					
				}
				catch(IOException e)
				{
					e.printStackTrace();
					return;
				}
			}
	

		}


}



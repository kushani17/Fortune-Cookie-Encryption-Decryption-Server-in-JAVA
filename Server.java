import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.net.*;


public class Server {
	
	
static int[] fortuneBuff;

	public static void main(String[] args) 
	{
		try
		 {
			
			Thread th1 = new Thread(new myclass());
			 th1.start();
			 Thread th2= new Thread(new myclass2());
			 th2.start();
			 
		
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Server error:"+e.getMessage());
		 }

		
	}

}









// File Name GreetingServer.java
import java.net.*;
import java.io.*;
import java.util.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class GreetingServer extends Thread {
   private ServerSocket serverSocket;
   // private String name,age,food;
   String line;
   PrintStream os;
   public GreetingServer(int port) throws IOException {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(100000);
   }

   public static int addition(int a,int b){

     return(a+b);
   }

   public static int subtraction(int a,int b){
     return(a-b);
   }

   public static int division(int a,int b){
     return(a/b);
   }

   public static int multiplication(int a,int b){
     return(a*b);
   }

   public static int Calculator(int a,int b,String c)
   {
   int res=0;
     if (c.equals("+")){
         res =addition(a,b);
     }
     else if (c.equals("-")){
         res = subtraction(a,b);
     }
     else if (c.equals("/")){
         res = division(a,b);
     }
     else if (c.equals("*")){
         res = multiplication(a,b);
     }

     return(res);
   }

   public void run() {
      while(true) {
         try {
            System.out.println("Waiting for client on port " + 
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());
            
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            int a  = Integer.parseInt(in.readUTF());
            int b  = Integer.parseInt(in.readUTF());
            String c = in.readUTF();
            int result = Calculator(a,b,c);
            out.writeUTF(Integer.toString(result));
			   server.close();
            
         } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            break;
         } catch (IOException e) {
            e.printStackTrace();
            break;
         }
      }
   }
   
   public static void main(String [] args) {
	   int port = Integer.parseInt(args[0]);
	   
	   try {
         Thread t = new GreetingServer(port);
         t.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   
  
}
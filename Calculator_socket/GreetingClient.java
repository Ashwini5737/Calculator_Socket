import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.DataInputStream;

public class GreetingClient {

   public static void main(String [] args) {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataInputStream inputLine=null;
         DataOutputStream out = new DataOutputStream(outToServer);
         //DataInputStream in = new DataInputStream(inFromServer);
		
		 Scanner input = new Scanner(System.in);
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
		 
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         

         System.out.println("Enter the First element of calculator:");
		 int a = input.nextInt();
		 out.writeUTF(Integer.toString(a));
		 System.out.println("Enter the Second element of calculator:");
		 int b = input.nextInt();
		 out.writeUTF(Integer.toString(b));
		 System.out.println("Enter the Operator of calculator:");
		 String c = new String(input.next());
		 out.writeUTF(c);
		 System.out.println("\nThe result is:"+in.readUTF());
		 client.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
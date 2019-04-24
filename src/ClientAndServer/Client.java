package ClientAndServer;

import java.net.*;
import java.io.*;
import java.util.*;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) throws IOException
    {
        InetAddress ip = InetAddress.getLocalHost();
        Scanner scanner0 = new Scanner(System.in);
               
        Socket socket = new Socket(ip.getHostAddress(), 1342);
        Scanner scanner1 = new Scanner(socket.getInputStream());
        
        System.out.print("This is the client.\nPlease enter a string> ");
        String string = scanner0.nextLine();
        
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        
        printStream.println(string);
        
        String result = scanner1.nextLine();
        char[] arr = result.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            char updatedChar = arr[i];
            updatedChar -= 3;
            arr[i] = updatedChar;
        }
        
        System.out.println("\nThe client received \"" + result + "\"\nThe unshifted string is \"" + new String(arr) + "\"");
        
    }
}

package ClientAndServer;

import java.net.*;
import java.io.*;
import java.util.*;


public class Server 
{

    public static void main(String[] args) throws IOException
    {   
        
        ServerSocket serverSocket = new ServerSocket(1342);
        Socket socket = serverSocket.accept();
        Scanner scanner = new Scanner(socket.getInputStream());
        String string = scanner.nextLine();
        
        char[] arr = string.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            char updatedChar = arr[i];
            updatedChar += 3;
            arr[i] = updatedChar;
        }
        
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println(new String(arr));
        
        
    }
}

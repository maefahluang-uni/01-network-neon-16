package th.mfu;

import java.io.*;
import java.net.*;

// call mockup server at port 8080
public class MockWebClient {
    public static void main(String[] args) {

        // TODO: Create a socket to connect to the web server on port 8080
        try(Socket clientSocket = new Socket("localhost",8080)){
        // :TODO Create input and output streams for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        // TODO: send an HTTP GET request to the web server
        String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";
            out.print(request);
        // Read the response from the web server and print out to console
            System.out.println(in.readLine());
        // Close the socket
        clientSocket.close();
        }catch (IOException e){
            System.err.println("Error occured: "+e.getMessage());
        }
    }

}

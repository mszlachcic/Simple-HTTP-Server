package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionThread extends Thread{
    private final Socket socket;
    public ConnectionThread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try (this.socket) {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            String response = "HTTP/1.1 200 OK\r\n\r\n";

            if(line != null){
                if(line.startsWith("GET")) response += "GET request works!";
                else if(line.startsWith("POST")) response += "POST request works!";
                else if(line.startsWith("PUT")) response += "PUT request works!";
                else if(line.startsWith("DELETE")) response += "DELETE request works!";
            }

            this.socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

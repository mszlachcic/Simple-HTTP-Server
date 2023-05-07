package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(80);
        System.out.println("Listening for connection on port 80 .....");
        while(true) {
            try(Socket socket = server.accept()){
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK \r\n\r\n" + today;
                socket.getOutputStream()
                        .write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}
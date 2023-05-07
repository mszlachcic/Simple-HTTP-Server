package org.example;

import java.net.Socket;

public class ConnectionThread extends Thread{
    private Socket socket;
    public ConnectionThread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        System.out.println("Connection established!");
        try{
            for(int i=0; i < 10; i++){
                Thread.sleep(400);
                System.out.println("licznik" + i);
            }
        }
        catch (InterruptedException interruptedException){
            System.out.println("zostal przerwany");
        }
        System.out.println("Wątek kończy działanie");
    }

    public Socket getSocket() {
        return this.socket;
    }
}

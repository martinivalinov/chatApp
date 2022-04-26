package peertopeer;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread{
    private ServerSocket serverSocket;
    private Set<ServerThreadThread> serverThreadThreads = new HashSet<ServerThreadThread>();
    public ServerThread(String portNumb) throws IOException{
        serverSocket = new ServerSocket(Integer.valueOf(portNumb));
    }

    public void run(){
        try{
            ServerThreadThread serverThreadThread = new ServerThreadThread(serverSocket.accept(), 
            this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void sendMessage(String message){
        try{
            serverThreadThreads.forEach(t-> t.getPrintWriter().println(message));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Set<ServerThreadThread> getServerThreadThreads(){
        return serverThreadThreads;
    }
}

package peertopeer;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThreadThread extends Thread{
    private ServerThread serverThread;
    private Socket socket;
    private PrintWriter printWriter;
    public ServerThreadThread(Socket socket, ServerThread serverThread){
        this.serverThread = serverThread;
        this.socket = socket;
    }

    public void run(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
            (this.socket.getInputStream()));
        } catch (Exception e) {
            serverThread.getServerThreadThreads().remove(this);
        }
    }

    public PrintWriter getPrintWriter(){
        return printWriter;
    }
}

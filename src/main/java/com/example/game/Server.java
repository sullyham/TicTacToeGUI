package com.example.game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket socket; //Server
    Socket client;
    BufferedReader keyboard;
    BufferedReader recieve;
    PrintWriter send;
    String username;
    String friendname;
    public Server() throws IOException {
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("hey welcome to shitty chatting platform 9999!");
        System.out.println("Please enter a username: ");
        username = keyboard.readLine();
        System.out.printf("Nice, %s is a great name\n", username);
        socket = new ServerSocket(9999);
        System.out.println("[SERVER] Waiting for client connection..");
        client = socket.accept();
        System.out.println("[SERVER] Client connected!");
        recieve = new BufferedReader(new InputStreamReader(client.getInputStream()));
        send = new PrintWriter(client.getOutputStream(), true);
        friendname = recieve.readLine();
        System.out.println(friendname + " has entered the chat!");
        send.println(username);
        while(true){
            String chatmessage = "";
            System.out.print("<");
            chatmessage = keyboard.readLine();
            send.printf("%s\n", chatmessage);
            System.out.printf("[%s] %s\n",username, chatmessage);
            String recievemessage = recieve.readLine();
            if(recievemessage.contains("quit")){
                System.out.println(friendname + " has left the chat.");
                break;
            }
            System.out.printf("[%s] %s\n",friendname, recievemessage);
        }
        socket.close();
        keyboard.close();
        send.close();
    }

    static void main() throws IOException {
        Server server = new Server();
    }
}

package com.example.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Socket client;
    BufferedReader keyboard;
    BufferedReader recieve;
    PrintWriter send;
    String username;
    String friendname;
    public Client() throws IOException {
        client = new Socket("localhost",9999);
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        recieve = new BufferedReader(new InputStreamReader(client.getInputStream()));
        send = new PrintWriter(client.getOutputStream(), true);
        System.out.println("hey welcome to shitty chatting platform 9999!");
        System.out.println("Please enter a username: ");
        username = keyboard.readLine();
        System.out.printf("Nice, %s is a great name\n", username);
        send.println(username);
        friendname = recieve.readLine();
        while(true){
            String recievemessage = recieve.readLine();
            System.out.printf("[%s] %s\n",friendname, recievemessage);
            String chatmessage = "";
            System.out.print("<");
            chatmessage = keyboard.readLine();
            send.printf("%s\n", chatmessage);
            System.out.printf("[%s] %s\n",username, chatmessage);
            if(chatmessage.contains("quit")){
                break;
            }
        }
        client.close();
        keyboard.close();
    }

    static void main() throws IOException {
        Client client1 = new Client();
    }
}

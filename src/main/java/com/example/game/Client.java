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

    }

    static void main() throws IOException {
        Client client1 = new Client();
    }
}

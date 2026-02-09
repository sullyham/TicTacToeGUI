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

    }

    static void main() throws IOException {
        Server server = new Server();
    }
}

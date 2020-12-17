package com.company;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

public class Player {

    private final Socket client;
    private final String name;
    private char playerSymbol;
    private final BufferedReader clientReader;
    private final PrintStream clientWriter;

    public Player(Socket client, String name, BufferedReader clientReader, PrintStream clientWriter) {
        this.client = client;
        this.name = name;
        this.clientReader = clientReader;
        this.clientWriter = clientWriter;
    }
    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public Socket getClient() {
        return client;
    }
    public String getName() {
        return name;
    }

    public BufferedReader getClientReader() {
        return clientReader;
    }
    public PrintStream getClientWriter() {
        return clientWriter;
    }
}

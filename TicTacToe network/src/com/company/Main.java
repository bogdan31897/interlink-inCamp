package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {


    public static final int PORT = 4040;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4040);
        ArrayList<Player> Players = new ArrayList<>();

        for(int i = 0; i < 2; i++) {
            Players.add(waitForClient(serverSocket, i+1));
        }

        Player playerX = Players.get(0);
        Player PlayerO = Players.get(1);

        playerX.setPlayerSymbol('X');
        PlayerO.setPlayerSymbol('O');

        int fieldSize = choiceFieldSizeByPlayer(Players.get(0));

        Game game = new Game(playerX,PlayerO,fieldSize);
        game.startGame();

        System.out.println("\nPlaying field size selected.");

        System.out.println("\nGame started!");
        do {

            game.getPlayer().getClientWriter().printf("-> (%c) Player %s enter your bet: ",game.getPlayer().getPlayerSymbol(),game.getPlayerName());
            game.getOtherPlayer().getClientWriter().printf("-> (%c) Player %s is betting, wait your move..",game.getOtherPlayer().getPlayerSymbol(), game.getPlayer().getName());

            int[] bet = isBetCorrect(game);
            game.Turn(bet[0], bet[1]);

            game.drawWinner();

        }while (game.getStatus() == 0);

    }

    private static int choiceFieldSizeByPlayer(Player player) throws IOException {
        String fieldSize;
        int sizeInt;
        while (true) {
            player.getClientWriter().printf("-> %s, enter playing field size: ", player.getName());
            fieldSize = player.getClientReader().readLine();
            if(isDegit(fieldSize)){
                sizeInt = Integer.parseInt(fieldSize);
                if(isInRange(sizeInt)) return sizeInt;
            }
        }
    }
    private static Player waitForClient(ServerSocket serverSocket, int playerId) throws IOException {
        System.out.printf("\nWaiting for %d player ...\n", playerId);
        Socket client = serverSocket.accept();
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintStream clientWriter = new PrintStream(client.getOutputStream());

        clientWriter.printf("-> Player %d enter your name: ", playerId);
        String playerName = clientReader.readLine();

        if(playerId == 1) clientWriter.printf("-> Hello, %s, waiting for second player... \n\r", playerName);
        else clientWriter.printf("-> Hello, %s, starting game....\n\r", playerName);

        System.out.printf("Player %s connected to %s. %s:%s\n",
                playerName,
                client.getLocalPort(),
                client.getInetAddress().getHostAddress(),
                client.getPort());

        return new Player(client, playerName, clientReader, clientWriter);
    }
    private static boolean isDegit(String s) throws NumberFormatException{
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
    private static boolean isInRange(int fieldSize) {
        return 3 <= fieldSize && fieldSize <= 6;
    }
    private static int[] isBetCorrect (Game game) throws IOException {
        String[] bets = game.getPlayer().getClientReader().readLine().split(" ");
        int[] bet = new int[2];
        while (true) {
            if(bets.length == 2) {
                if(isDegit(bets[0]) && isDegit(bets[1])) {
                    if(game.isInRangeField(Integer.parseInt(bets[0])) && game.isInRangeField(Integer.parseInt(bets[1]))) break;
                }
            }
            game.getPlayer().getClientWriter().printf("-> (%c) Player %s enter your bet: ",game.getPlayer().getPlayerSymbol(),game.getPlayerName());
            bets = game.getPlayer().getClientReader().readLine().split(" ");
        }
        bet[0] = Integer.parseInt(bets[0]);
        bet[1] = Integer.parseInt(bets[1]);
        return bet;
    }
}



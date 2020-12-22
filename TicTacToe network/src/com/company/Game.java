package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private final ArrayList<Player> players;
    private final Player playerX;
    private final Player playerO;
    private Player activePlayer;
    private Player winPlayer;
    private int gameStatus;
    private char[][] field;

    public Game(Player playerX, Player playerO, int fieldSize) {
        field = new char[fieldSize][fieldSize];
        activePlayer = playerX;
        gameStatus = 0;
        this.playerX = playerX;
        this.playerO = playerO;

        players = new ArrayList<>();
        players.add(playerX);
        players.add(playerO);
    }
    public void startGame() {
        defaultFillField();
        printField();
    }
    private void defaultFillField() {
        for (char[] row : field) {
            Arrays.fill(row, '-');
        }
    }
    private void printField() {
        drawPlayersInfo();
        for(Player player: players) {
            player.getClientWriter().println("\r\n".repeat(2));
            for (int j = 0; j <  field.length; j++) {
                player.getClientWriter().print("->    ");
                for(int i = 0; i < field[j].length; i++) {
                    player.getClientWriter().print(field[j][i]);
                    if(i != field[j].length - 1) player.getClientWriter().print(" | ");
                }
                if(j != field[j].length -1) {
                    player.getClientWriter().print("\n\r->   ");
                    player.getClientWriter().print("---".repeat(field[j].length) + "-".repeat(field.length -1));
                    player.getClientWriter().print("\n\r");
                }
            }
            player.getClientWriter().println("\r\n".repeat(6));
        }
    }
    public void draw(String string) {
        for(Player player: players) {
            player.getClientWriter().println(string);
        }
    }
    public void drawPlayersInfo() {
        for(Player drawPlayer: players) {
            drawPlayer.getClientWriter().println("\r\n".repeat(15) + "-> Players:\r");
            for (Player player :players ) {
                drawPlayer.getClientWriter().printf("->  (%c) %s\r\n", player.getPlayerSymbol(), player.getName());
            }
        }
    }
    public void drawWinner() {
        if(this.getStatus() == 1) this.draw(String.format("-> Win player: (%c) %s!\n\n", this.getWinPlayer().getPlayerSymbol(), this.getWinPlayer().getName()));
        else if(this.getStatus() == 2) this.draw(String.format("-> Win player: (%c) %s!\n\n",this.getWinPlayer().getPlayerSymbol(), this.getWinPlayer().getName()));
        else if(this.getStatus() == 3) this.draw("-> Draw!");
    }
    public void Turn(int x, int y) {
        x--;y--;
        if (field[x][y] == '-') {
            field[x][y] = activePlayer.getPlayerSymbol();
            activePlayer = (activePlayer == playerX ? playerO: playerX);
        }
        printField();
        analiseField();
    }
    private void analiseField() {
        Player isWinPlayer = searchWinLines();
        if (isWinPlayer.getPlayerSymbol() == playerX.getPlayerSymbol()) {
            gameStatus = 1;
            winPlayer = isWinPlayer;
        }
        else if(isWinPlayer.getPlayerSymbol() == playerO.getPlayerSymbol()) {
            gameStatus = 2;
            winPlayer = isWinPlayer;
        }
        else {
            if(isAllCellsSelected(field)) {
                gameStatus = 3;
            }
        }
    }
    private Player searchWinLines() {
        char[] diagonal1 = new char[field.length];
        char[] diagonal2 = new  char[field.length];

        for (int i = 0; i < field.length; i++) {

            char[] columns = new char[field.length];
            for (int j = 0; j < columns.length; j++) {
                columns[j] = field[j][i];
            }

            diagonal1[i] = field[i][i];
            diagonal2[i] = field[i][field.length - 1 - i];

            if (isLineWin(field[i], getOtherPlayer().getPlayerSymbol()) || isLineWin(columns, getOtherPlayer().getPlayerSymbol()) || isLineWin(diagonal1, getOtherPlayer().getPlayerSymbol()) || isLineWin(diagonal2, getOtherPlayer().getPlayerSymbol())) {
                return getOtherPlayer();
            }
        }
        return new Player(null,"Bogdan", null, null);
    }
    private boolean isLineWin(char[] line, char player) {
        for (char c : line) {
            if (c != player) return false;
        }
        return true;
    }
    private boolean isAllCellsSelected(char[][] field) {
        for (char[] chars : field) {
            for (int j = 0; j < field.length; j++) {
                if (chars[j] == '-') return false;
            }
        }
        return true;
    }
    public String getPlayerName() {
        return activePlayer.getName();
    }
    public Player getPlayer() {
        return activePlayer;
    }
    public Player getOtherPlayer() {return activePlayer == playerX ? playerO: playerX;}
    public Player getWinPlayer() {return winPlayer;}
    public int getStatus() {return gameStatus;}
    public boolean isInRangeField(int value) {
        return 0 <= value && value <= field.length;
    }
}

package com.company;

import java.util.Arrays;

public class Game {

    private static final char playerX = 'X';
    private static final char playerO = 'O';
    private char activePlayer;
    private char winPlayer;
    private int gameStatus;
    private char[][] field;

    public Game(int fieldSize) {
        field = new char[fieldSize][fieldSize];
        activePlayer = playerX;
        gameStatus = 0;
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
        System.out.println("\n\n");
        for (char[] row : field) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\n\n");
    }
    public void Turn(int x, int y) {
        x--;y--;
        if(isInRangeField(x) && isInRangeField(y)) {
            if (field[x][y] == '-') {
                field[x][y] = activePlayer;
                activePlayer = (activePlayer == playerX ? playerO: playerX);
            }
            printField();
            analiseField();
        }
    }
    private void analiseField() {
        char isWinPlayer = searchWinLines();
        if (isWinPlayer == playerX) {
            gameStatus = 1;
            winPlayer = isWinPlayer;
        }
        else if(isWinPlayer == playerO) {
            gameStatus = 2;
            winPlayer = isWinPlayer;
        }
        else {
            if(isAllCellsSelected(field)) {
                gameStatus = 3;
            }
        }
    }
    private char searchWinLines() {
        char[] diagonal1 = new char[field.length];
        char[] diagonal2 = new  char[field.length];

        for (int i = 0; i < field.length; i++) {

            char[] columns = new char[field.length];
            for(int j = 0; j < columns.length; j++) {
                columns[j] = field[j][i];
            }

            diagonal1[i] = field[i][i];
            diagonal2[i] = field[i][field.length-1-i];

            if(isLineWin(field[i], playerX) || isLineWin(columns, playerX) || isLineWin(diagonal1, playerX) || isLineWin(diagonal2, playerX)) {
                return playerX;
            }else if(isLineWin(field[i], playerO) || isLineWin(columns, playerO) || isLineWin(diagonal1, playerO) || isLineWin(diagonal2, playerO)) {
                return playerO;
            }
        }
        return 0;
    }
    private boolean isLineWin(char[] line, char player) {
        for (int i = 0; i < line.length;  i++) {
            if(line[i] != player) return false;
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
    public char getPlayer() {
        return activePlayer;
    }
    public char getWinPlayer() {return winPlayer;}
    public int getStatus() {return gameStatus;}
    private boolean isInRangeField(int value) {
        return 0 <= value && value < field.length;
    }
}

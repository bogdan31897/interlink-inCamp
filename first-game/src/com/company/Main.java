package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char playerX = 'X';
    static char playerO = 'O';
    static char activePlayer = playerX;
    static int gameStatus = 0;
    static char[][] field;
    static Scanner scanner = new Scanner(System.in);

    public static void startGame() {
        System.out.print("Write size: ");

        int fieldSize = scanner.nextInt();
        field = new char[fieldSize][fieldSize];

        defaultFillField();
        printField(field);
    }
    public static void defaultFillField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = '-';
            }
        }
    }
    public static void printField(char[][] field) {
        System.out.println("");
        for (int row = 0; row < field.length; row++) {
            System.out.println(Arrays.toString(field[row]));
        }
        System.out.println("");
    }
    public static void getFieldBet(Scanner scanner, char player) {
        int row = 0;  int column = 0;

        System.out.print("Player " + player + " enter bet: ");
        row = scanner.nextInt() - 1; column = scanner.nextInt() - 1;

        if (field[row][column] == '-') {
            field[row][column] = player;
            activePlayer = (activePlayer == playerX ? playerO: playerX);
        }else {
            System.out.println("This cell is selected, try other: ");
            activePlayer = player;
        }
    }
    public static char analiseField(char[][] field) {
        char winPlayer = searchWinLines(field);
        if (winPlayer == playerX) {
            gameStatus = 1;
            return winPlayer;
        }
        else if(winPlayer == playerO) {
            gameStatus = 2;
            return winPlayer;
        }
        else {
            if(isAllCellsSelected(field)) {
                gameStatus = 3;
            }
        }
        return 0;
    }
    public static char searchWinLines(char[][] field) {
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
    public static boolean isLineWin(char[] line, char player) {
        for (int i = 0; i < line.length;  i++) {
            if(line[i] != player) return false;
        }
        return true;
    }
    public static boolean isAllCellsSelected(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for(int j = 0; j < field.length; j++) {
                if(field[i][j] == '-') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        while(true) {

            System.out.print("Enter /start to start game: ");
            String commandLine = scanner.nextLine();
            if (commandLine.equals("/start")) {

                System.out.print("Enter size: ");
                int fieldSize = scanner.nextInt();

                //start new game
                Game game = new Game(fieldSize);
                game.startGame();

                do {
                    System.out.printf("Player: %s enter bet: ", game.getPlayer());
                    int x = scanner.nextInt(); int y = scanner.nextInt();
                    //make Turn
                    game.Turn(x,y);

                    //check game status
                    if(game.getStatus() == 1) System.out.printf("Win player: %c!\n\n", game.getWinPlayer());
                    else if(game.getStatus() == 2) System.out.printf("Win player: %c!\n\n", game.getWinPlayer());
                    else if(game.getStatus() == 3) System.out.println("draw");


                }while (game.getStatus() == 0);

            }
        }


    }
}

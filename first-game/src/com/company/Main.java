package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

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
                    System.out.printf("-> Player: %s enter bet: ", game.getPlayer());
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

package elhaouari.floodit.game;

import java.util.Scanner;

public class MainConsole {

    public static void printGrid(GameFloodit game) {
        for (int[] line : game.getBoard().getGrid()) {
            System.out.print("------");
        }
        System.out.println();
        for (int[] line : game.getBoard().getGrid()) {
            for (int j = 0; j < line.length; j++) {
                System.out.print("|  " + line[j] + "  ");
                if ( j == game.getBoard().getGrid().length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < game.getBoard().getGrid().length; j++) {
                System.out.print("-----");
                if ( j != game.getBoard().getGrid().length - 1) {
                    System.out.print("+");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }
    

    public static void startConsoleGame(GameFloodit game) {
        game.initBoardWithRandomColor();
        printGrid(game);
        while (game.getBoard().getRound() < game.getBoard().MAX_ROUND) {
            System.out.print("Entre un nombre " + game.getBoard().getRound() + ": ");
            Scanner s = new Scanner(System.in);
            game.updateBoardByNewColor(s.nextInt());
            printGrid(game);
        }
    }

    public static void main(String[] args) {
        GameFloodit game = new GameFloodit(35, 15);

        startConsoleGame(game);

    }
    
}

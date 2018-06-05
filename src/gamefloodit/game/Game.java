/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefloodit.game;

import java.util.Scanner;

/**
 *
 * @author nabil
 */
public class Game {
    
    /**
     * show the grid in the console
     * @param game
     */
    public static void tracerGrid(GameFloodit game) {
        for (int[] line : game.getGrid()) {
            System.out.print("------");
        }
        System.out.println();
        for (int[] line : game.getGrid()) {
            for (int j = 0; j < line.length; j++) {
                System.out.print("|  " + line[j] + "  ");
                if ( j == game.getGrid().length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < game.getGrid().length; j++) {
                System.out.print("-----");
                if ( j != game.getGrid().length - 1) {
                    System.out.print("+");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }
    
    /**
     * start game
     * @param game
     */
    public static void startConsoleGame(GameFloodit game) {
        game.initGame();
        tracerGrid(game);
        while (game.getRound() < game.getMaxRound()) {
            System.out.print("Entre un nombre " + game.getRound() + ": ");
            Scanner s = new Scanner(System.in);
            game.play(s.nextInt());
            tracerGrid(game);
        }
    }
    
    /**
     * main method
     * 
     * @param args 
     */
    public static void main(String[] args) {
        GameFloodit game = new GameFloodit();

        startConsoleGame(game);

    }
    
}

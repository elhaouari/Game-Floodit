package gamefloodit.gmae;

import java.util.Random;
import java.util.Scanner;

public class GameFloodit {

    /**
     *
     */
    private int number = 6;
    private int tour;
    private final int TOUR_MAX = 25;
    private final int TAILLE_GRILLE = 15;
    private int grille[][];

    /**
     *
     */
    public void initGame() {
        grille = new int[TAILLE_GRILLE][TAILLE_GRILLE];

        Random rand = new Random();

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = rand.nextInt(number);
            }
        }
    }

    public void nouvellePartied() {
        initGame();
        tour = 0;
    }

    public void colorer(int color) {
        if (color < 0 || color > 6) {
            return;
        }

        if (grille[0][0] != color) {
            colorer(color, grille[0][0], 0, 0);
        }
        
        tour++;
    }

    private void colorer(int newColor, int oldColor, int row, int col) {
        // make sure row and col are inside the image
        if (row < 0 || col < 0 || row >= TAILLE_GRILLE || col >= TAILLE_GRILLE) {
            return;
        }
        
        // make sure this pixel is the right color to fill
        if ( grille[row][col] != oldColor) {
            return;
        }
        
        // fill pixel with target color and mark it as visited
        grille[row][col] = newColor;
        
        // recursively fill surrounding pixels
        // (this is equivelant to depth-first search)
        colorer(newColor, oldColor, row - 1, col);
        colorer(newColor, oldColor, row + 1, col);
        colorer(newColor, oldColor, row, col - 1);
        colorer(newColor, oldColor, row, col + 1);
    }

    public void orderOptimal() {
        int index_Max_Occurence;
        while (!verifier()) {
            index_Max_Occurence = calculeOccurenceMax();
            colorer(index_Max_Occurence);
        }
    }

    public boolean verifier() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if (grille[i][j] != grille[0][0]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public void tracerGrile() {
        for (int i = 0; i < grille.length; i++) {
            System.out.print("------");
        }
        System.out.println();
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print("|  " + grille[i][j] + "  ");
                if ( j == grille.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < grille.length; j++) {
                System.out.print("-----");
                if ( j != grille.length - 1) {
                    System.out.print("+");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public void jeu() {
        initGame();
        tracerGrile();
        while (tour < TOUR_MAX) {
            System.out.print("Entre un nombre " + tour + ": ");
            Scanner s = new Scanner(System.in);
            colorer(s.nextInt());
            tracerGrile();
        }
    }

    private int calculeOccurenceMax() {
        return 0;
    }

    public static void main(String[] args) {
        GameFloodit jeu = new GameFloodit();

        jeu.jeu();

    }

    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int[][] getGrille() {
        return grille;
    }

    public void setGrille(int[][] grille) {
        this.grille = grille;
    }

    
}
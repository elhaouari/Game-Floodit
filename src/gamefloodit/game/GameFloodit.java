package gamefloodit.game;

import java.util.Random;

public class GameFloodit {

    /**
     *
     */
    private int numberOfColor = 6;
    private int round;
    private final int MAX_ROUND;
    private final int GRID_SIZE;
    private int grid[][];

    /**
     * initialize the game grid with random value
     */
    public GameFloodit() {
        MAX_ROUND = 35;
        GRID_SIZE = 15;
    }
    
    /**
     * 
     * @param maxRound
     * @param gridSize 
     */
    public GameFloodit(int maxRound, int gridSize) {
        MAX_ROUND = maxRound;
        GRID_SIZE = gridSize;
    }
    
    /**
     * initialize the game grid with random value
     */
    public void initGame() {
        grid = new int[GRID_SIZE][GRID_SIZE];

        Random rand = new Random();

        for (int[] line : grid) {
            for (int j = 0; j < line.length; j++) {
                line[j] = rand.nextInt(numberOfColor);
            }
        }
    }

    /**
     * start new game
     */
    public void newGame() {
        initGame();
        round = 0;
    }

    /**
     * play a round, put color in the grid
     * @param color 
     */
    public void play(int color) {
        if (color < 0 || color > 6) {
            return;
        }

        if (grid[0][0] != color) {
            play(color, grid[0][0], 0, 0);
        }
        
        round++;
    }

    /**
     * play recursive
     * 
     * @param newColor
     * @param oldColor
     * @param row
     * @param col 
     */
    private void play(int newColor, int oldColor, int row, int col) {
        // make sure row and col are inside the image
        if (row < 0 || col < 0 || row >= GRID_SIZE || col >= GRID_SIZE) {
            return;
        }
        
        // make sure this pixel is the right color to fill
        if ( grid[row][col] != oldColor) {
            return;
        }
        
        // fill pixel with target color and mark it as visited
        grid[row][col] = newColor;
        
        // recursively fill surrounding pixels
        // (this is equivelant to depth-first search)
        play(newColor, oldColor, row - 1, col);
        play(newColor, oldColor, row + 1, col);
        play(newColor, oldColor, row, col - 1);
        play(newColor, oldColor, row, col + 1);
    }

    /**
     * play an order optimal
     */
    public void orderOptimal() {
        int index_Max_Occurence;
        while (!verify()) {
            index_Max_Occurence = calculeOccurenceMax();
            play(index_Max_Occurence);
        }
    }

    /**
     * check if the play win the round
     * 
     * @return 
     */
    public boolean verify() {
        for (int[] line : grid) {
            for (int j = 0; j < line.length; j++) {
                if (line[j] != grid[0][0]) {
                    return false;
                }
            }
        }
        
        return true;
    }


    /**
     * check the optimal play
     * @return 
     */
    private int calculeOccurenceMax() {
        return 0;
    }
    
    public int getNumberOfColor() {
        return numberOfColor;
    }

    public int getMaxRound() {
        return this.MAX_ROUND;
    }
    
    public void setNumberOfColor(int numberOfColor) {
        this.numberOfColor = numberOfColor;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getGridSize() {
        return GRID_SIZE;
    }
    
    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
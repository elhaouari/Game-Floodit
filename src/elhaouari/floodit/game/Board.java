package elhaouari.floodit.game;

public class Board {

    private int numberOfColor = 6;
    private int round;
    public final int MAX_ROUND;
    public final int GRID_SIZE;
    private int[][] grid;
    
    public Board() {
        MAX_ROUND = 35;
        GRID_SIZE = 20;
    }

    public Board(int maxRound, int gridSize) {
        MAX_ROUND = maxRound;
        GRID_SIZE = gridSize;
    }

    public int getNumberOfColor() {
        return numberOfColor;
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

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}

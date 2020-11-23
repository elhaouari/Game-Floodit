package elhaouari.floodit.game;

import java.util.Random;

public class GameFloodit {

    private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameFloodit(int maxRound, int gridSize) {
        board = new Board(maxRound, gridSize);
    }

    public void initBoardWithRandomColor() {
        var grid = new int[board.GRID_SIZE][board.GRID_SIZE];

        Random rand = new Random();

        for (int[] line : grid) {
            for (int j = 0; j < line.length; j++) {
                line[j] = rand.nextInt(board.getNumberOfColor());
            }
        }

        board.setGrid(grid);
    }

    public void newGame() {
        initBoardWithRandomColor();
        board.setRound(0);
    }

    public void updateBoardByNewColor(int color) {
        if (color < 0 || color > 6) {
            return;
        }

        if (board.getGrid()[0][0] != color) {
            updateBoardByNewColor(color, board.getGrid()[0][0], 0, 0);
        }
        
        board.setRound(board.getRound() + 1);
    }


    private void updateBoardByNewColor(int newColor, int oldColor, int row, int col) {
        // make sure that row and col are inside the board
        if (row < 0 || col < 0 || row >= board.GRID_SIZE || col >= board.GRID_SIZE) {
            return;
        }
        
        // make sure that current pixel can be calored with the new one
        if ( board.getGrid()[row][col] != oldColor) {
            return;
        }

        board.getGrid()[row][col] = newColor;
        
        // recursively fill surrounding pixels
        // (this is equivelant to depth-first search)
        updateBoardByNewColor(newColor, oldColor, row - 1, col);
        updateBoardByNewColor(newColor, oldColor, row + 1, col);
        updateBoardByNewColor(newColor, oldColor, row, col - 1);
        updateBoardByNewColor(newColor, oldColor, row, col + 1);
    }

    public void orderOptimal() {
        int index_Max_Occurence;
        while (!verify()) {
            index_Max_Occurence = calculeOccurenceMax();
            updateBoardByNewColor(index_Max_Occurence);
        }
    }

    public boolean verify() {
        for (int[] line : board.getGrid()) {
            for (int i : line) {
                if (i != board.getGrid()[0][0]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private int calculeOccurenceMax() {
        return 0;
    }

}
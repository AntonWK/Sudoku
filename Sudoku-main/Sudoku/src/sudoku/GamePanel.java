package sudoku;

import java.awt.Dimension;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Collections;

class GamePanel extends Panel {

    public GamePanel() {
        int[][] grid = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        setPreferredSize(new Dimension(800, 800));
        if(createSudoku(grid)){
        System.out.print("success");
        }
    }

    private boolean createSudoku(int grid[][]) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                for (int n = 0; n <= grid.length; n++) {
                    int numberToTry = rand(grid);
                    if (isValidPlacement(grid, numberToTry, x, y)) {
                        grid[x][y] = numberToTry;
                        if (createSudoku(grid)) {
                                   return true;
                        } else {
                            grid[x][y] = 0;
                        }
                    }
                }
                return false;        
            }
        }
    
        System.out.print(grid);
        return true;
    }

 

    private static boolean isNumberInRow(int[][] grid, int num, int x) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[x][i] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] grid, int num, int y) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][y] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int num, int x, int y) {
        int boxX = x - x % 3;
        int boxY = y - y % 3;
        for (int i = boxX; i < boxX + 3; i++) {
            for (int j = boxY; j < boxY + 3; j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] grid, int num, int x, int y) {
        return !isNumberInRow(grid, num, x)
                && !isNumberInColumn(grid, num, y)
                && !isNumberInBox(grid, num, x, y);
    }

    private int rand(int grid[][]) {
        int min = 1;
        int max = grid.length+1;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

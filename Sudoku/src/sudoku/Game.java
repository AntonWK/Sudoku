package sudoku;

import java.awt.Dimension;
import java.awt.Panel;
import java.util.ArrayList;

public class Game extends Panel {

            int removedNumbers = 0;

    
    public Game() {
        int size = 9;
        int remove = 2;
        int grid[][] = createGrid(size);

        setPreferredSize(new Dimension(800, 800));
        if (createSudoku(grid, size)) {
            printSudoku(grid, size);
            removePeices(grid, size, remove);
            printSudoku(grid, size);
        }
    }

    protected static boolean isNumberInRow(int[][] grid, int num, int x) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[x][i] == num) {
                return true;
            }
        }
        return false;
    }

    protected static boolean isNumberInColumn(int[][] grid, int num, int y) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][y] == num) {
                return true;
            }
        }
        return false;
    }

    protected static boolean isNumberInBox(int[][] board, int num, int x, int y, int size) {
        int boxX = x - x % (int) Math.sqrt(size);
        int boxY = y - y % (int) Math.sqrt(size);
        for (int i = boxX; i < boxX + (int) Math.sqrt(size); i++) {
            for (int j = boxY; j < boxY + (int) Math.sqrt(size); j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    protected static boolean isValidPlacement(int[][] grid, int num, int x, int y, int size) {
        return !isNumberInRow(grid, num, x) && !isNumberInColumn(grid, num, y) && !isNumberInBox(grid, num, x, y, size);
    }

    protected boolean createSudoku(int[][] grid, int size) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[x][y] == 0) {
                    for (int n = 0; n < grid.length; n++) {
                        int numberToTry = rand(grid);
                        if (isValidPlacement(grid, numberToTry, x, y, size)) {
                            grid[x][y] = numberToTry;
                            if (createSudoku(grid, size)) {
                                return true;
                            } else {
                                grid[x][y] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    protected int rand(int[][] grid) {
        int min = 1;
        int max = grid.length;
        return (int) (Math.random() * (max - min + 1) + min);
    }

    protected void printSudoku(int[][] grid, int size) {
        for (int i = 0; i < grid.length; i++) {
            if (i % (int) Math.sqrt(size) == 0) {
                System.out.println("+-------+-------+-------+");
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (j % (int) Math.sqrt(size) == 0) {
                    System.out.print("| ");
                }
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }

    protected int[][] createGrid(int size) {
        int[][] grid = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                grid[x][y] = 0;
            }
        }
        printSudoku(grid, size);
        return grid;
    }

    private boolean removePeices(int[][] grid, int size, int numbersToRemove) {
        /* välj en random ruta
        är rutan != 0, tabort numret
        kolla hur många lösningar brädet har
        om den har 1 lösning, fortsätt till nästa nummer
        */
        int x = rand(grid);
        int y = rand(grid);
        int temp = grid[x][y];
        grid[x][y] = 0;
        if(checkSolutions(grid) && temp != grid[x][y]){
        
        }
    }

    private boolean checkSolutions(int grid[][]) {
        // kolla mängden lösningar med rekusion och skicka tillbacks true eller false
        // just nu skapar den bara en lösning
        ArrayList<Integer> possibleSolutions = new ArrayList<Integer>();
       for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[x][y] == 0) {
                    for (int numberToTry = 1; numberToTry < grid.length; numberToTry++) {
                        if (isValidPlacement(grid, numberToTry, x, y, grid.length)) {
                            grid[x][y] = numberToTry;
                            if (checkSolutions(grid)) {
                                return true;
                            } else {
                                grid[x][y] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}

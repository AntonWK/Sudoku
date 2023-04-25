package sudoku;

import java.awt.Dimension;
import java.awt.Panel;
import java.util.Arrays;

public class Game extends Panel {

    int size = 4;
    int grid[][] = createGrid(size);
    int remove = 3;

//    public static void main(String[] args) {
//        Game game = new Game();
//        game.grid[0][1] = 2;
//        game.printSudoku(game.grid, 6);
//        boolean ok1= game.isNumberInBox(game.grid, 1, 0, 0, 6);
//        System.out.println(ok1);
//    }
    public Game() {
        int[][] originalGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[0].length; k++) {
                originalGrid[i][k] = grid[i][k];
            }
        }

        setPreferredSize(new Dimension(800, 800));
        if (createSudoku(grid, size)) {
            printSudoku(grid, size);
            grid[rand(grid) - 1][rand(grid) - 1] = 0;
            removePieces(grid, originalGrid);
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

    protected static boolean isNumberInBox(int[][] grid, int num, int x, int y, int size) {
        int boxX = x - x % (int) Math.sqrt(size);
        int boxY = y - y % (int) Math.sqrt(size);
        for (int i = boxX; i < boxX + (int) Math.sqrt(size); i++) {
            for (int j = boxY; j < boxY + (int) Math.sqrt(size); j++) {
                if (grid[i][j] == num) {
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

    private void removePieces(int[][] grid, int[][] originalGrid) {

        /* välj en random ruta
        är rutan != 0, tabort numret
        kolla hur många lösningar brädet har
        om den har 1 lösning, fortsätt till nästa nummer
         */
        System.out.print(remove + " ");
        printSudoku(grid, grid.length);

        int x, y;
        do {
            x = rand(grid) - 1;
            y = rand(grid) - 1;
            System.out.print(grid[x][y]);
        } while (grid[x][y] == 0);
        int tmp = grid[x][y];

        int solutions = 0;
        for (int j = 0; j < grid.length; j++) {
            grid[x][y] = j + 1;

            int[][] tempGrid = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int k = 0; k < grid[0].length; k++) {
                    tempGrid[i][k] = grid[i][k];
                }
            }
            if (checkSolutions(tempGrid, originalGrid)) {
                solutions += 1;
            }
        }
        System.out.print("solutions = " + solutions + "... ");
        if (solutions == 1) {
            if (remove != 0) {
                remove -= 1;
                grid[x][y] = 0;
                removePieces(grid, originalGrid);
            }
        } else if (remove != 0) {
            grid[x][y] = tmp;
            removePieces(grid, originalGrid);
        }
    }

    private boolean checkSolutions(int grid[][], int[][] originalGrid) /* behöver bli matad med en temp grid*/ {
        // kolla mängden lösningar med rekusion och skicka tillbacks true eller false
        // just nu skapar den bara en lösning
        //ArrayList<Integer> possibleSolutions = new ArrayList<Integer>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[x][y] == 0) {
                    for (int numberToTry = 1; numberToTry <= grid.length; numberToTry++) {
                        if (isValidPlacement(grid, numberToTry, x, y, grid.length)) {
                            grid[x][y] = numberToTry;
                            if (checkSolutions(grid, originalGrid)) {
                                return true;
                            } else {
                                System.out.print("FFF ");
                                grid[x][y] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        // if eq orig re T else re F
        if (compareGrids(grid, originalGrid)) {
            return true;
        } else {
            System.out.print("F ");
            return false;
        }
    }

    private boolean compareGrids(int[][] grid, int[][] originalGrid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[x][y] != originalGrid[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}

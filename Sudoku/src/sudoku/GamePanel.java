package sudoku;

import java.awt.Dimension;
import java.awt.Panel;

class GamePanel extends Panel{
    int[][] grid = new int[][] {        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },   
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },   
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },   
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },   
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },   
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },   
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },   
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },   
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }   
                                     } ;  

    public GamePanel() {
        setPreferredSize(new Dimension(800, 800));
        createSudoku();
    }

    private void createSudoku() {
        gridReset();
        int size = grid.length;
        int min=0;
        int max = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = (int)(Math.random()*(max-min+1)+min);
              /*  for (int k = 0; k < size; k++) {
                if(grid[i][j]== grid[i][k]){
                    grid[i][j] = (int)(Math.random()*(max-min+1)+min);
                } if(grid[i][j]== grid[k][j]){
                    grid[i][j] = (int)(Math.random()*(max-min+1)+min);
                }*/
                System.out.print(grid[i][j]+ "|");
                    }
        System.out.println();
        System.out.print("- - - - - - - - -");
        System.out.println();
        }
    }
        
    
    private void gridReset() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j]=0;
            }
            }
        
    }

}

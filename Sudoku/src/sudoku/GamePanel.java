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
        int min=1;
        int max = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = (int)(Math.random()*(max-min+1)+min);
                grid[i][j] = num(grid,i,j,max,min);    
                
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
    
    static int num(int grid[][], int x,int y, int max, int min){
        int[] l ={};
        for (int i = 0; i < grid.length; i++) {
            if(i!= grid[x][y]){
                l[i]=i+1;
            }
        }//skapa lista med möjliga nummer
        for (int i = 0; i < l.length; i++) {
            if(grid[x][i] == l[i] || grid[i][y] == l[i]){
                l = ArrayUtils.remove(l,i); // om nummer i listan av möjliga inte är möjliga, ta bort nummer
            } else {
                grid[x][y]= (int)(Math.random()*(max-min+1)+min);
                return num(grid,x,y,max,min);
            }
        }
        return 10;
    }

}

package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;


public class NormalSudoku extends Game{

    public NormalSudoku() {
        super();
    }
    
    
    void drawGrid(Graphics grphcs) {
        int cellSize = 50;
        Graphics2D g = (Graphics2D) grphcs;
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 800, 800);
        g.setPaint(Color.BLACK);
        for (int i = 0; i < mySudoku.gridSize + 1; i++) {
            if (i % (Math.sqrt(mySudoku.gridSize)) == 0) {
                g.setStroke(new BasicStroke(3));
            } else {
                g.setStroke(new BasicStroke(1));
            }
            g.drawLine(0, cellSize * i, cellSize * (mySudoku.gridSize), cellSize * i);
            g.drawLine(cellSize * i, 0, cellSize * i, cellSize * (mySudoku.gridSize));
        }
        for (int i = 0; i < mySudoku.grid.length; i++) {
            for (int j = 0; j < mySudoku.grid.length; j++) {
                if (mySudoku.grid[i][j] != 0) {
                    if (mySudoku.originalGrid[i][j] != 0) {
                        g.setPaint(Color.BLUE);
                    } else {
                        g.setPaint(Color.BLACK);
                    }
                    g.drawString(Integer.toString(mySudoku.grid[i][j]), cellSize * j + (cellSize / 2 - 5), cellSize * i + (cellSize / 2) + 8);
                }
            }
        }
    }

    @Override
    void uppdateNumber(KeyEvent e, Point point) {
        mySudoku.grid[point.x][point.y] = Character.getNumericValue(e.getKeyCode());
    }
}

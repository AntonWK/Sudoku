package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Game {

    SudokuGrid mySudoku = new SudokuGrid(9, 20);
    Button checkGame = new Button(550, 50, 150, 50, "Done!", 12);
    Point point = new Point();

    public Game() {
        point.setLocation(9, 9);
    }

    void drawGrid(Graphics grphcs) {
        int cellSize = 50;
        Graphics2D g = (Graphics2D) grphcs;
        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
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
                    g.drawString(Integer.toString(mySudoku.grid[i][j]), cellSize * j + (cellSize / 2 - 3), cellSize * i + (cellSize / 2) + 4);
                }
            }
        }
    }

    void act(Point location) {
        point = selectCell(location);
    }

    private Point selectCell(Point location) {
        Point p = new Point();
        int y = (int) Math.floor(location.getX() / 50);
        int x = (int) Math.floor(location.getY() / 50);
        if (x > 8 || y > 8) {
            p.setLocation(9, 9);
            return p;
        } else {
            p.setLocation(x, y);
            return p;
        }
    }

    void drawButtons(Graphics grphcs) {
        checkGame.drawcheckSolutionbutton(grphcs);
    }
}

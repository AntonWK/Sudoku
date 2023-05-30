package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

abstract class Game {

    SudokuGrid mySudoku = new SudokuGrid(9, 20);
    Button checkGame = new Button(550, 50, 150, 50, "Done!", 12);
    Point point = new Point();

    public Game() {
        point.setLocation(9, 9);
    }

    abstract void drawGrid(Graphics grphcs);

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

    abstract void uppdateNumber(KeyEvent e, Point point);
}

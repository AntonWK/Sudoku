package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Gudoku extends Game {

    HashMap<Integer, String> refferences = new HashMap<>();
    HashMap<String, Integer> reverceRefferences = new HashMap<>();

    public Gudoku() {
        super();
        refferences.put(1, "A");
        refferences.put(2, "B");
        refferences.put(3, "C");
        refferences.put(4, "D");
        refferences.put(5, "E");
        refferences.put(6, "F");
        refferences.put(7, "G");
        refferences.put(8, "H");
        refferences.put(9, "I");
        reverceRefferences.put("a", 1);
        reverceRefferences.put("b", 2);
        reverceRefferences.put("c", 3);
        reverceRefferences.put("d", 4);
        reverceRefferences.put("e", 5);
        reverceRefferences.put("f", 6);
        reverceRefferences.put("g", 7);
        reverceRefferences.put("h", 8);
        reverceRefferences.put("i", 9);

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
                    g.drawString(refferences.get(mySudoku.grid[i][j]), cellSize * j + (cellSize / 2 - 5), cellSize * i + (cellSize / 2) + 8);
                }
            }
        }
    }

    @Override
    void uppdateNumber(KeyEvent e, Point point) {
                mySudoku.grid[point.x][point.y] = reverceRefferences.get(e.getKeyChar());
    }
}

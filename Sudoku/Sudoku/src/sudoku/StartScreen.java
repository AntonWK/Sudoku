package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class StartScreen {

    Button normalS = new Button(300, 190, 200, 50, "9X9 Sudoku", 20);
    Button gudoku = new Button(300, 280, 200, 50, "Gudoku", 20);

    public StartScreen() {

    }

    void drawStartScreen(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 800, 800);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(3));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.drawString("Welcome to Anton's Sudoku!", 150, 80);
        g.drawString("Choose Gamemode:", 220, 140);
    }

    void drawButtons(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        normalS.drawcheckSolutionbutton(grphcs);
        gudoku.drawcheckSolutionbutton(grphcs);
    }
}

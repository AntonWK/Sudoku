package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

class EndScreen {

    Button replay = new Button(300, 190, 200, 50, "Play Again", 20);
    Button menu = new Button(300, 280, 200, 50, "Main Menu", 20);


    void drawEndGame(Graphics grphcs, boolean win) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 800, 800);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(3));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        if (win) {
            g.drawString("YOU WON!", 290, 140);
        } else {
            g.drawString("GAME OVER", 280, 80);
            g.drawString("YOU LOST!", 300, 140);

        }
    }

    void drawEndLoose(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, 800, 800);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(3));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.drawString("GAME OVER!", 150, 80);
    }

    void drawButton(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        replay.drawcheckSolutionbutton(grphcs);
        menu.drawcheckSolutionbutton(grphcs);
    }
}

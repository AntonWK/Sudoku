
package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;


class Button {

    int x,y,w,h,fontSize;
    String name;
    
    public Button(int xPos, int yPos, int wVal, int hVal, String text, int size) {
        x = xPos;
        y = yPos;
        w = wVal;
        h = hVal;
        fontSize = size;
        name = text;
    }
    
    void drawcheckSolutionbutton(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.setPaint(Color.BLACK);
        g.drawRect(x, y, w, h);
        g.setPaint(Color.CYAN);
        g.fillRect(x, y, w, h);
        g.setPaint(Color.BLACK);
        drawCenteredString(name,x,y,w,h, g);
    }
    
    public void drawCenteredString(String s, int x1, int y1, int w, int h, Graphics g) {
    FontMetrics fm = g.getFontMetrics();
    int x = x1 + w/2 - fm.stringWidth(s)/ 2;
    int y = y1 + (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
    g.drawString(s, x, y);
  }
    
    boolean isPressed(Point e){
        return(e.x > x && e.x < x + w && e.y > y && e.y < y + h);
    }
}

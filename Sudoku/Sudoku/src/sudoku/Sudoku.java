package sudoku;

import java.awt.*;
import java.awt.event.*;

public class Sudoku extends Frame {

     GamePanel gp = new GamePanel();

    public Sudoku(){
        add(gp);
        pack();
        addWindowListener(wl());
        gp.requestFocus();
        setVisible(true);
        run();
    }
     
    public void run(){
        while (true) {
            gp.nextFrame();
            gp.repaint();
            try {
                Thread.sleep(12);
            } catch (Exception e) {
            }
        }
    }
    
     public static void main(String[] args) {
        new Sudoku();
    } 
     
      private WindowListener wl() {
        return new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
            
        };
    }
}

package sudoku;

import java.awt.*;
import java.awt.event.*;

public class Sudoku extends Frame{

     GamePanel gp = new GamePanel();

    public Sudoku(){
        add(gp);
        pack();
        addWindowListener(wl());
        gp.requestFocus();
        setVisible(true);
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

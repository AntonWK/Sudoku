package sudoku;

import java.awt.*;
import java.awt.event.*;

public class Sudoku extends Frame {

    SharedPanel gp = new StartPanel(this);

    public Sudoku() {
        add(gp);
        pack();
        addWindowListener(wl());
        gp.requestFocus();
        setVisible(true);
        run();
    }

    static enum State { START, PLAYS, PLAYG, WIN, LOOSE }
    
    public void swithcState(State s) {
        remove(gp);
        switch(s){
            case START:
                gp = new StartPanel(this);
                break;
            case PLAYS:
                gp = new GamePanel(this, true);
                break;
            case PLAYG:
                gp = new GamePanel(this, false);
                break;
            case WIN:
                gp = new GameOver(this, true,gp);
                break;
            case LOOSE:
                gp = new GameOver(this, false,gp);
                break;
        }
        add(gp);
        revalidate();
    }

    public void run() {
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
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }

        };
    }
}

package sudoku;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class StartPanel extends SharedPanel implements MouseListener {

    StartScreen start = new StartScreen();

    public StartPanel(Sudoku s) {
        super(s);
        
    }

    void nextFrame() {
    }

    public void paint(Graphics grphcs) {
        start.drawStartScreen(grphcs);
        start.drawButtons(grphcs);           
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(start.normalS.isPressed(e.getPoint())){
            sudoku.swithcState(Sudoku.State.PLAYS);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}

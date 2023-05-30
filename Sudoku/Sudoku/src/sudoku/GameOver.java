/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author anton
 */
public class GameOver extends SharedPanel implements MouseListener {

    EndScreen end = new EndScreen();
    boolean winGame;
    SharedPanel preveousGame;

    GameOver(Sudoku s, boolean win, SharedPanel preveousGameType) {
        super(s);
        winGame = win;
        preveousGame = preveousGameType;
    }

    void nextFrame() {
    }

    public void paint(Graphics grphcs) {
        end.drawEndGame(grphcs, winGame);
        end.drawButton(grphcs);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (end.replay.isPressed(e.getPoint())) {
            if (preveousGame.getClass().equals(Gudoku.class)) {
                System.out.print("same");
                sudoku.swithcState(Sudoku.State.PLAYG);
            } else if (preveousGame.getClass().equals(NormalSudoku.class)) {
                System.out.print("same");
                sudoku.swithcState(Sudoku.State.PLAYS);
            }
        } else if (end.menu.isPressed(e.getPoint())) {
            sudoku.swithcState(Sudoku.State.START);
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

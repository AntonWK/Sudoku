package sudoku;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GamePanel extends SharedPanel implements MouseListener, KeyListener {

    Game game = new Game();
    Point location = new Point();    

    public GamePanel(Sudoku s) {
        super(s);
        location.setLocation(dimensions, dimensions);
        addKeyListener(this);
    }

    void nextFrame() {
        game.act(location);
    }

    public void paint(Graphics grphcs) {
        game.drawGrid(grphcs);
        game.drawButtons(grphcs);        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        location = e.getPoint();
        if (game.checkGame.isPressed(e.getPoint())){
            if(game.mySudoku.compareGrids(game.mySudoku.grid, game.mySudoku.solvedGrid)){
            System.out.print("Done!");
            }
            else{
             game.mySudoku.printSudoku(game.mySudoku.grid, 9);
             sudoku.swithcState(Sudoku.State.GAMEOVER);
            System.out.print("fail");
            }
            // game over?? victory??
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (game.point.x < game.mySudoku.grid.length
                && game.point.y < game.mySudoku.grid.length
                && Character.getNumericValue(e.getKeyChar()) <= game.mySudoku.grid.length
                && game.mySudoku.originalGrid[game.point.x][game.point.y] == 0) {
            int newNumb = Character.getNumericValue(e.getKeyCode());
            try {
                game.mySudoku.grid[game.point.x][game.point.y] = newNumb;
            } catch (Exception m) {
            }
        }
        if (e.getKeyCode() == 8 && game.mySudoku.originalGrid[game.point.x][game.point.y] == 0) {
            game.mySudoku.grid[game.point.x][game.point.y] = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

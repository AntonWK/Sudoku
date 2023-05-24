package sudoku;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

class GamePanel extends Panel implements MouseListener, KeyListener {

    public int dimensions = 800;
    BufferedImage bgi = new BufferedImage(dimensions, dimensions, BufferedImage.TYPE_INT_ARGB);
    Game game = new Game();
    Point location = new Point();

    public GamePanel() {
        setPreferredSize(new Dimension(dimensions, dimensions));
        location.setLocation(dimensions, dimensions);
        addMouseListener(this);
    }

    void nextFrame() {
        game.act(location);
    }

    public void paint(Graphics grphcs) {
        game.drawGrid(grphcs);
    }

    public void update(Graphics grphcs) {
        bgi.getGraphics().clearRect(0, 0, bgi.getWidth(), bgi.getHeight());
        paint(bgi.getGraphics());
        grphcs.drawImage(bgi, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("hej");
        location = e.getPoint();
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
        System.out.println("hej");
        if (game.point.x < game.mySudoku.grid.length + 1 && game.point.y < game.mySudoku.grid.length + 1 && (int) e.getKeyChar() < game.mySudoku.grid.length + 2 && (int) e.getKeyChar() > 0) {
            game.mySudoku.grid[game.point.x][game.point.y] = (int) e.getKeyChar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

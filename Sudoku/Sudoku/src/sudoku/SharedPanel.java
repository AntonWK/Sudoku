package sudoku;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

abstract class SharedPanel extends Panel implements MouseListener {

    public int dimensions = 800;
    BufferedImage bgi = new BufferedImage(dimensions, dimensions, BufferedImage.TYPE_INT_ARGB);
    Sudoku sudoku;

    public SharedPanel(Sudoku s) {
        setPreferredSize(new Dimension(dimensions, dimensions));
        sudoku = s;
        addMouseListener(this);
    }

    abstract void nextFrame();
    
    abstract public void paint(Graphics grphcs);

    public void update(Graphics grphcs) {
        bgi.getGraphics().clearRect(0, 0, bgi.getWidth(), bgi.getHeight());
        paint(bgi.getGraphics());
        grphcs.drawImage(bgi, 0, 0, null);
    }
}

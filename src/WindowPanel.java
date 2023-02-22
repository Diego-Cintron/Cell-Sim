import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WindowPanel extends JPanel implements Runnable {
    private boolean windowRunning = true;
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = (int)(WINDOW_WIDTH*(0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
    Thread windowThread;
    Image image;
    Graphics graphics;
//    BaseCell cell;
    Cells cells;
    Buttons buttons;

    WindowPanel() {
//        cell = new SomaticCell(1,100, 100); // Move this to Cells.java where there will be a counter for ID
        cells = new Cells();
        buttons = new Buttons();

        this.setFocusable(true);
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(SCREEN_SIZE);

        windowThread = new Thread(this);
        windowThread.start();
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0, this);
    }

    public void draw(Graphics g) {
        cells.draw(g);
    }

    // Updates the position of the cells.
    public void move() {
        cells.move();
    }

    // Simulation loop
    public void run() {

        long lastTime = System.nanoTime();
        double amountOfTicks = 100;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;

        while (windowRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) { // Every tick
                move();
                repaint();
                delta--;
            }
        }
    }

    // Listens to key presses
    public class ActionListener extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            buttons.keyPressed(e, cells);
        }
        public void keyReleased(KeyEvent e) {
            buttons.keyReleased(e);
        }
    }
}

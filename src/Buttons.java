import java.awt.event.KeyEvent;

public class Buttons {
    boolean pressed1 = false;
    boolean pressed2 = false;
    boolean pressed3 = false;

    public void keyPressed(KeyEvent e, Cells cells) {

        if (e.getKeyCode() == KeyEvent.VK_1) { // If someone presses A
            if (!pressed1) {
                cells.createCell(1);
                pressed1 = true;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_2) { // If someone presses D
            if (!pressed2) {
                cells.createCell(2);
                pressed2 = true;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_3) {
            if (!pressed3) {
                cells.createCell(3);
                pressed3 = true;
            }
        }

    }

    // Stops the player's movement once they let go of the key.
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_1) {
            pressed1 = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_2) {
            pressed2 = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_3) {
            pressed3 = false;
        }

    }
}

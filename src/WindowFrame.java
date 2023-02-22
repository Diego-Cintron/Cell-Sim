import java.awt.*;
import javax.swing.*;

public class WindowFrame extends JFrame{

    WindowFrame() {

        this.add(new WindowPanel());
        this.setTitle("Cell Simulator");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
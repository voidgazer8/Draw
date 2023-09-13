import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    private final Panel panel;

    public Window() {
        panel = new Panel();
        add(panel);
    }
}

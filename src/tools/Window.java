package tools;

import tools.CustomPanel;

import javax.swing.*;

public class Window extends JFrame {
    private final CustomPanel panel;

    public Window() {
        panel = new CustomPanel();
        add(panel);
    }
}

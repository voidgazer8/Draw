package tools;

import components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomPanel extends JPanel implements Runnable {
    private final Sky sky;
    private final Ground ground;
    private final LaunchSite site;
    private final Sun sun;
    private final Spacecraft rocket;
    private final Mountain mountain;
    private Graphics2D g;
    private Thread thread;

    public CustomPanel() {
        rocket = new Spacecraft(295, 600);
        site = new LaunchSite(170, 570);
        ground = new Ground(1000, 400, 0, 600, Color.decode("#33270a"));
        sun = new Sun(650, 400, 100, Color.red);
        mountain = new Mountain(0, 0);

        sky = new Sky(0, 0, 1000, 600, true, new LinearGradientPaint(
                new Point(0, 0),
                new Point(0, 600),
                new float[]{0.01f, 0.3f, 0.5f, 0.7f},
                new Color[]{
                        Color.black,
                        Color.decode("#3A1C71"),
                        Color.decode("#D76D77"),
                        Color.decode("#FFAF7B")}
        ));

        setLayout(null);

        JButton timer = new JButton();
        timer.setLocation(450, 650);
        timer.setBorderPainted(false);
        timer.setFocusPainted(false);
        timer.setText("Start!");
        timer.setForeground(Color.green);
        timer.setBackground(Color.darkGray);
        timer.setFont(new Font("Impact", Font.BOLD, 25));
        timer.setSize(100, 50);

        timer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer.setBackground(Color.decode("#7ECAF0"));
                timer.setForeground(Color.black);
                new Thread(() -> {
                    for (int x = 3; x >= 0; x--) {
                        timer.setText(x + ":00");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    timer.setText("Start!");
                    timer.setForeground(Color.green);
                    timer.setBackground(Color.darkGray);
                    thread.start();
                }).start();
            }
        });
        add(timer);
    }

    @Override
    public void run() {
        for (int k = 30; k > 2; k--) {
            site.setAngle1(Math.PI / k);
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int k = 30; k > 2; k--) {
            site.setAngle2(-Math.PI / k);
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while (true) {
            rocket.setY(rocket.getY() - 20);
            repaint();
            if (rocket.getY() < -300) {
                String[] options = {"OK"};
                int input = JOptionPane.showOptionDialog(null, "Запуск прошёл успешно", "ЦУП", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, "OK");
                if (input == JOptionPane.OK_OPTION || input == JOptionPane.CLOSED_OPTION) {
                    rocket.setY(600);
                    site.setAngle1(0);
                    site.setAngle2(0);
                    rocket.draw(g);
                    repaint();
                }

                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void paint(Graphics gr) {

        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        this.g = g;

        thread = new Thread(this);
        sky.draw(gr);
        sun.draw(g);
        mountain.draw(g);
        rocket.draw(g);
        g.setStroke(new BasicStroke(1));
        ground.draw(g);
        site.draw(g);
    }
}

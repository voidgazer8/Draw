import components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Timer;
import java.util.TimerTask;

public class Panel extends JPanel implements Runnable {
    private Sky sky;
    private Ground ground;

    private LaunchSite site;
    private Sun sun;
    private Spacecraft rocket;
    private Thread thread;



    private Graphics2D g;


    public Panel() {
        rocket = new Spacecraft(125, 570);
        site = new LaunchSite(30, 570, 0, null);
        ground = new Ground(1000, 400, 0, 600, Color.decode("#33270a"));
        sun = new Sun(800, 600, 100, Color.red);

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
    }

    @Override
    public void run() {
        while (true) {
            rocket.setY(rocket.getY() - 20);
            repaint();
            if (rocket.getY() < 10) {
                rocket.setY(570);
                rocket.draw(g);
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
        this.g=g;
        setLayout(null);

        thread = new Thread(this);
        sky.draw(gr);
        sun.draw(g);
        ground.draw(g);
        site.draw(g);
        rocket.draw(g);

        JButton timer = new JButton();
        timer.setLocation(450, 650);
        timer.setBorderPainted(false);
        timer.setFocusPainted(false);
        timer.setBackground(Color.darkGray);
        timer.setFont(new Font("Impact", Font.BOLD, 25));
        timer.setSize(100, 50);

        timer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer.setBackground(Color.decode("#7ECAF0"));
                Timer timer1 = new Timer();
                timer1.schedule(new TimerTask() {
                    int x = 3;

                    @Override
                    public void run() {
                        timer.setText(x + ":00");
                        x--;
                        if (x == 0) {
                            cancel();
                            thread.start();
                        }
                    }
                }, 0, 1000);
            }
        });
        add(timer);
    }
}

package components;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class LaunchSite {
    private int x, y;
    private double angle1, angle2;

    public double getAngle1() {
        return angle1;
    }

    public double getAngle2() {
        return angle2;
    }

    public void setAngle2(double angle2) {
        this.angle2 = angle2;
    }

    public void setAngle1(double angle1) {
        this.angle1 = angle1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public LaunchSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#091C02"));
        g.fillOval(x + 65, y - 25, 50, 50);
        g.fillOval(x + 260, y - 25, 50, 50);
        g.setColor(Color.decode("#212020"));
        g.fillRect(x, y, 250, 30);
        g.setColor(Color.decode("#091C02"));
        g.fillRect(x+250, y, 100, 30);


        g.setColor(Color.decode("#091C02"));
        g.fillRect(x + 125, y - 20, 120, 20);
        g.setColor(Color.decode("#212020"));

        g.rotate(angle2, x + 90, y + 30);
        g.setColor(Color.decode("#212020"));
        g.fillRect(x + 95, y - 300, 20, 320);


        GeneralPath path = new GeneralPath();
        path.moveTo(x + 95, y - 280);
        path.lineTo(x + 115, y - 320);
        path.lineTo(x + 115, y - 280);
        g.fill(path);
        path.reset();

        g.fillRect(x + 88, y - 300, 3, 300);
        g.setStroke(new BasicStroke(2));

        for (int yi = y - 300; yi < y; yi += 10) {
            g.drawLine(x + 90, yi, x + 95, yi + 8);
        }

        for (int yi = y - 150; yi < y; yi += 40) {
            g.fillRect(x + 108, yi, 30, 10);
        }

        g.setStroke(new BasicStroke(1));
        g.setColor(Color.decode("#091C02"));

        if (angle2 != 0) {
            g.rotate(-angle2, x + 90, y + 30);
        }
        g.rotate(angle1, x + 260, y - 25);
        path.moveTo(x + 265, y - 15);
        path.lineTo(x + 233, y - 100);
        path.lineTo(x + 233, y - 150);
        path.lineTo(x + 305, y - 15);
        g.fill(path);
    }
}

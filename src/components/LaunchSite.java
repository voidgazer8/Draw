package components;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class LaunchSite implements Drawing {
    private final int countOfSupportiveStructures;
    private int x;
    private int y;
    private final Color color;

    public LaunchSite(int x, int y, int countOfSupportiveStructures, Color color) {
        this.countOfSupportiveStructures = countOfSupportiveStructures;
        this.color = color;
        this.x = x;
        this.y = y;
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

    private static class SupportiveStructure implements Drawing {

        @Override
        public void draw(Graphics2D g) {

        }
    }
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#0D2404"));
        g.fillRect(x, y, 330, 30);
        g.fillOval(x + 35, y - 25, 50, 50);
        g.fillOval(x + 230, y - 25, 50, 50);

        g.fillRect(x + 65, y - 300, 20, 300);
        GeneralPath path = new GeneralPath();
        path.moveTo(x + 65, y - 300);
        path.lineTo(x + 85, y - 320);
        path.lineTo(x + 85, y - 300);
        g.fill(path);
        path.reset();

        g.fillRect(x + 58, y - 300, 3, 300);
        g.setStroke(new BasicStroke(2));

        for (int yi = y - 300; yi < y; yi += 10) {
            g.drawLine(x + 60, yi, x + 65, yi + 8);
        }

        for (int yi = y - 200; yi < y; yi += 40) {
            g.fillRect(x + 85, yi, 30, 10);
        }

        g.setStroke(new BasicStroke(1));
        path.moveTo(x + 235, y - 15);
        path.lineTo(x + 203, y - 100);
        path.lineTo(x + 203, y - 150);
        path.lineTo(x + 275, y - 15);
        g.fill(path);

    }
}

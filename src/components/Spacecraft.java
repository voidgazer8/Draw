package components;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Spacecraft {
    private int x, y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }

    private Graphics2D g;

    public Spacecraft(int x, int y) {
        this.x = x;
        this.y = y;
    }


    private void setUpLinesFeatures() {
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.black);
        g.drawLine(x + 30, y - 350, x + 90, y - 350);

        g.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0));
        g.drawLine(x + 40, y - 130, x + 40, y - 350);
        g.setStroke(new BasicStroke(1));
        g.drawLine(x + 40, y - 130, x + 40, y - 350);
        g.drawLine(x + 35, y - 130, x + 35, y - 350);


        g.setColor(Color.decode("#60778B"));
        g.setStroke(new BasicStroke(1));
        g.drawLine(x + 35, y - 390, x + 35, y - 450);
        g.fillArc(x + 35, y - 455, 5, 10, 0, 180);
        g.setStroke(new BasicStroke(3));
        g.drawLine(x + 40, y - 450, x + 40, y - 405);
    }

    private void setUpRepeatedLinesElements() {
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.black);
        for (int d = y - 100; d > y - 130; d -= 4) {
            g.drawLine(x + 30, d, x + 90, d);
        }
    }

    private void setUpCaptionElement() {
        g.setColor(Color.decode("#0D5697"));
        g.setFont(new Font("Impact", Font.PLAIN, 12));
        g.drawString("РосКосмос", x + 30, y - 20);
    }

    private void setUpFlagElement() {
        Color[] colors = new Color[]{Color.white, Color.blue, Color.red};
        int d = 370;
        for (Color c : colors) {
            g.setColor(c);
            g.fillRect(x + 53, y - d, 12, 3);
            d -= 3;
        }
    }

    private void setUpRocketEngineElements() {
        GeneralPath path = new GeneralPath();
        g.setColor(Color.black);
        path.moveTo(x, y);
        path.lineTo(x + 30, y - 100);
        path.lineTo(x + 90, y - 100);
        path.lineTo(x + 120, y);
        g.fill(path);
        path.reset();

        g.setColor(Color.decode("#700909"));
        path.moveTo(x + 30, y - 100);
        path.lineTo(x + 30, y - 130);
        path.lineTo(x + 90, y - 130);
        path.lineTo(x + 90, y - 100);
        g.fill(path);
        path.reset();

        g.setColor(Color.white);
        path.moveTo(x + 6, y - 20);
        path.lineTo(x + 9, y - 29);
        path.lineTo(x + 111, y - 29);
        path.lineTo(x + 114, y - 20);
        g.fill(path);
        path.reset();

        g.setColor(Color.decode("#96AEC3"));
        path.moveTo(x + 30, y - 130);
        path.lineTo(x + 30, y - 350);
        path.lineTo(x + 90, y - 350);
        path.lineTo(x + 90, y - 130);
        g.fill(path);
        path.reset();

        g.setColor(Color.decode("#96AEC3"));
        g.fillArc(x + 30, y - 425, 60, 150, 0, 180);

        g.setColor(Color.decode("#51606E"));
        path.moveTo(x + 12, y - 40);
        path.lineTo(x + 12, y - 180);
        path.curveTo(x + 12, y - 180, x + 35, y - 220, x + 30, y - 260);
        path.lineTo(x + 30, y - 100);
        g.fill(path);

        path.reset();
        path.moveTo(x + 108, y - 40);
        path.lineTo(x + 108, y - 180);
        path.curveTo(x + 108, y - 180, x + 85, y - 220, x + 90, y - 260);
        path.lineTo(x + 90, y - 100);
        g.fill(path);

    }

    public void draw(Graphics2D g) {
        this.g = g;
        setUpFlame();
        setUpRocketEngineElements();
        setUpFlagElement();
        setUpCaptionElement();
        setUpRepeatedLinesElements();
        setUpLinesFeatures();
    }

    private void setUpFlame() {
        LinearGradientPaint grad = new LinearGradientPaint(
                new Point(x, y),
                new Point(x, y + 300),
                new float[]{0.2f, 0.7f, 1f},
                new Color[]{
                        Color.decode("#FFFF9C"),
                        Color.red,
                        new Color(100, 100, 100, 0)}
        );

        LinearGradientPaint grad2 = new LinearGradientPaint(
                new Point(x, y + 140),
                new Point(x, y - 50),
                new float[]{0.6f, 0.95f},
                new Color[]{
                        Color.white,
                        new Color(100, 100, 100, 0)}
        );
        LinearGradientPaint grad3 = new LinearGradientPaint(
                new Point(x + 50, y),
                new Point(x + 190, y),
                new float[]{0.001f, 0.95f},
                new Color[]{
                        Color.white,
                        new Color(100, 100, 100, 0)}
        );

        LinearGradientPaint grad4 = new LinearGradientPaint(
                new Point(x + 50, y),
                new Point(x - 140, y),
                new float[]{0.001f, 0.95f},
                new Color[]{
                        Color.white,
                        new Color(100, 100, 100, 0)}
        );

        g.setPaint(grad);
        g.fillRect(x, y, 120, 300);
        g.setPaint(grad2);
        g.fillRect(x, y - 50, 120, 70);
        g.setPaint(grad3);
        g.fillRect(x + 50, y - 10, 240, 30);
        g.setPaint(grad4);
        g.fillRect(x - 120, y - 10, 220, 30);
    }
}

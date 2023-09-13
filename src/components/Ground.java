package components;

import java.awt.*;

public class Ground implements Drawing {
    private final int width, height, x, y;
    private Color color;

    public Ground(int width, int height, int x, int y, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        for (int i = y + 25; i < y + height; i += 10) {
            int[] x = new int[width];
            int[] y = new int[width];
            for (int j = 0; j < width; j++) {
                x[j] = j;
                y[j] = -10 + i + (int) (8 * Math.sin(j*1.3));
            }
            g.drawPolyline(x, y, width);
        }
    }
}

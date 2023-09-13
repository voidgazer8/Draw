package components;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sky  {
    private final int width, height, x, y;
    private LinearGradientPaint gradient = null;
    private Color simpleColor = null;

    private int k = 0;
    private boolean stars, n = true;
    BufferedImage bufferedImage;

    private Sky(int x, int y, int width, int height, boolean stars) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.stars = stars;
    }

    public Sky(int x, int y, int width, int height, boolean stars, LinearGradientPaint gradient) {
        this(x, y, width, height, stars);
        this.gradient = gradient;

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        g.setPaint(gradient != null ? gradient : simpleColor);
        g.fillRect(x, y, width, height);

        g.setStroke(new BasicStroke(2));
        int xs = 1;
        int f = 255;
        for (int d1 = 0; d1 < height / 2; d1 += 50) {
            g.setColor(new Color(255, 255, 255, f));
            for (int d = 0; d < width; d += 40) {
                Random r = new Random();
                int ys = r.nextInt(50);
                int h = (xs % 2 == 0) ? d - 100 : d + 100;
                g.drawLine(h, ys + d1, h, ys + d1);
            }
            xs++;
            f -= 50;

        }

    }

    public Sky(int x, int y, int width, int height, boolean stars, Color simpleColor) {
        this(x, y, width, height, stars);
        this.simpleColor = simpleColor;
    }



    public void draw(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, null);
    }
}

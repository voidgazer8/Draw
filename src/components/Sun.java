package components;

import java.awt.*;

public class Sun implements Drawing {

    private int x,y,r;
    private Color color;

    public Sun(int x, int y,int r, Color color) {
        this.x=x;
        this.y=y;
        this.r = r;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x-r,y-r,2*r,2*r);
    }
}

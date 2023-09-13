package components;

import java.awt.*;

public interface Drawing {
    void draw(Graphics2D g);



    /*default void draw(Graphics2D g, double scalingFactorX, double scalingFactorY) {
        throw new UnsupportedOperationException("Не реализовано");
    }

    default void draw(Graphics2D g, double rotatingAngle) {
        throw new UnsupportedOperationException("Не реализовано");
    }

    default void draw(Graphics2D g,  double scalingFactorX, double scalingFactorY, double rotatingAngle) {
        throw new UnsupportedOperationException("Не реализовано");
    }*/
}

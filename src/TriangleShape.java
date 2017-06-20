import java.awt.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 30/10/2016.
 */
public class TriangleShape extends Shape {
    Point one, two, three;
    TriangleShape(Point one, Point two, Point three, Color colour, int strokeSize) {
        super(colour, strokeSize);
        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public Color getColour() {
        return colour;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawLine(getOne().x, getOne().y, getTwo().x, getTwo().y);
        g2d.drawLine(getTwo().x, getTwo().y, getThree().x, getThree().y);
        g2d.drawLine(getThree().x, getThree().y, getOne().x, getOne().y);
    }

    public Point getOne() {
        return one;
    }

    public Point getTwo() {
        return two;
    }

    public Point getThree() {
        return three;
    }

    @Override
    public int getStrokeSize() {
        return strokeSize;
    }
}

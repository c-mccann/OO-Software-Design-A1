import java.awt.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 30/10/2016.
 */
public class CircleShape extends Shape{
    Point centre;
    int diameter;
    CircleShape(Point centre, int diameter, Color colour, int strokeSize){
        super(colour, strokeSize);
        this.centre = centre;
        this.diameter = diameter;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public Color getColour() {
        return colour;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // radius is multiplied by 2 to give diameter as drawOval draws an oval within a rectangle, and the
        // width and height of the rectangle is defined by the 3rd and 4th arg of drawOval
        g2d.drawOval(getCentre().x, getCentre().y, getDiameter(), getDiameter());
    }

    @Override
    public int getStrokeSize() {
        return strokeSize;
    }

    public Point getCentre() {
        return centre;
    }

    public int getDiameter() {
        return diameter;
    }
}

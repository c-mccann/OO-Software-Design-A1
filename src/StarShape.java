import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by C12508463 on 04/11/2016.
 */
public class StarShape extends Shape {

    Point top, secondPoint;
    double distance;
    StarShape(Point top, Point secondPoint,Color colour, int strokeSize){
        super(colour,strokeSize);
        this.top = top;
        this.secondPoint = secondPoint;
        this.distance = Point.distance(secondPoint.x, secondPoint.y,
                top.x, top.y);
    }

    @Override
    public String getShapeName() {
        return "Star";
    }

    @Override
    public Color getColour() {
        return colour;
    }

    @Override
    public void draw(Graphics2D g2d) {
        double slope = (secondPoint.getY() - top.getY()) /
                (secondPoint.getX() - top.getX());

        Point oldPoint = secondPoint;
        Point newPoint;

        AffineTransform oldTransform = g2d.getTransform();
        double rotation = -1 * Math.atan((0 - slope) / 1 + (0 * slope));

        AffineTransform affineTransform = AffineTransform.getRotateInstance(rotation,
                top.getX(),top.getY());

        g2d.setTransform(affineTransform);


        g2d.drawLine(top.x, top.y, secondPoint.x, secondPoint.y);

        double angle = Math.toRadians(-144);

        for (int i = 0; i < 4; i++) {
            newPoint = new Point((int)(oldPoint.x + (distance * Math.cos(angle))),
                    (int)(oldPoint.y + (distance * Math.sin(angle))));
            g2d.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
            oldPoint = newPoint;

            angle += Math.toRadians(144);
        }
        g2d.setTransform(oldTransform);
    }

    @Override
    public int getStrokeSize() {
        return strokeSize;
    }
}

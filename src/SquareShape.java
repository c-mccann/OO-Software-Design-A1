import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 30/10/2016.
 */
public class SquareShape extends Shape {

    Point topLeft;
    double length;
    double rotation;
    AffineTransform affineTransform;
    SquareShape(Point topLeft, Point topRight, Color colour, int strokeSize){
        super(colour, strokeSize);
        double slope = (topRight.getY() - topLeft.getY()) / (topRight.getX() - topLeft.getX());


        this.topLeft = topLeft;
        this.length = Math.sqrt(Math.pow(topRight.getX() - topLeft.getX(),2) + Math.pow(topRight.getY() - topLeft.getY(),2));
        // canvas on horizontal line, gives it a slope of 0, mult by -1 as quadrants of circle running counter clockwise
        rotation = -1 * Math.atan((0 - slope) / 1 + (0 * slope));



        if(topLeft.getX() > topRight.getX()){
            //if topRight is on the left
            this.topLeft = topRight;
        }
        this.affineTransform = AffineTransform.getRotateInstance(rotation, this.topLeft.getX(),this.topLeft.getY());

    }

    public AffineTransform getAffineTransform() {
        return affineTransform;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public double getLength(){
        return length;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public Color getColour() {
        return colour;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform oldSetting = g2d.getTransform();
        g2d.setTransform(getAffineTransform());
        g2d.drawRect(getTopLeft().x, getTopLeft().y, (int)getLength(),(int)(getLength()));
        g2d.setTransform(oldSetting);
    }

    @Override
    public int getStrokeSize() {
        return strokeSize;
    }

}

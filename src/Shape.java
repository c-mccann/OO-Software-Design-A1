import java.awt.*;
import java.io.Serializable;

/**
 * Created by C12508463 on 28/10/2016.
 *
 * abstract class for specific shapes to inherit
 */
public abstract class Shape implements Serializable {
    protected Color colour;
    protected int strokeSize;
    Shape(Color colour, int strokeSize){
        this.colour = colour;
        this.strokeSize = strokeSize;
    }

    public abstract String getShapeName();
    public abstract Color getColour();
    public abstract void draw(Graphics2D g2d);
    public abstract int getStrokeSize();
}

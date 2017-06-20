import javax.sound.sampled.Line;
import java.awt.*;
import java.io.Serializable;

/**
 * Created by C12508463 on 28/10/2016.
 */
public class LineShape extends Shape {
    Point start, end;
    LineShape(Point start, Point end, Color colour, int strokeSize) {
        super(colour, strokeSize);
        this.start = start;
        this.end = end;
    }

    public String getShapeName(){
        return "Line";
    }

    @Override
    public Color getColour() {
        return colour;
}

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawLine(getStart().x, getStart().y, getEnd().x, getEnd().y);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public int getStrokeSize() {
        return strokeSize;
    }

}

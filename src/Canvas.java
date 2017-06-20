import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.util.List;

import static java.awt.RenderingHints.KEY_ANTIALIASING;

/**
 * Created by C12508463 on 26/10/2016.
 */
public class Canvas extends JPanel{

    private List<Point> tempPoints = new ArrayList<>();
    private List<Shape> shapes = new ArrayList<>();
    private Point currentHoverPoint;
    private Color currentColour = Color.BLACK;
    private String currentShape = "Line";
    private int currentStrokeSize = 5;

    Canvas() {
        setBackground(Color.WHITE);
//        setOpaque(true);
        setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);
                int key = keyEvent.getKeyCode();
                switch(key){
                    case KeyEvent.VK_0:
                        currentStrokeSize = 1;
                        break;
                    case KeyEvent.VK_1:
                        currentStrokeSize = 1;
                        break;
                    case KeyEvent.VK_2:
                        currentStrokeSize = 2;
                        break;
                    case KeyEvent.VK_3:
                        currentStrokeSize = 3;
                        break;
                    case KeyEvent.VK_4:
                        currentStrokeSize = 4;
                        break;
                    case KeyEvent.VK_5:
                        currentStrokeSize = 5;
                        break;
                    case KeyEvent.VK_6:
                        currentStrokeSize = 6;
                        break;
                    case KeyEvent.VK_7:
                        currentStrokeSize = 7;
                        break;
                    case KeyEvent.VK_8:
                        currentStrokeSize = 8;
                        break;
                    case KeyEvent.VK_9:
                        currentStrokeSize = 9;
                        break;
                }

            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                super.mouseMoved(mouseEvent);
                currentHoverPoint = mouseEvent.getPoint();
            }
        });

        // was going to move this code into its own class, but made accessing tempPoints awkward so I left it
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                tempPoints.add(mouseEvent.getPoint());
                switch (currentShape){
                    case "Line":
                        if(tempPoints.size() == 2){
                            shapes.add(new LineShape(tempPoints.get(0), tempPoints.get(1), currentColour,
                                    currentStrokeSize));
                            tempPoints.clear();
                        }
                        break;
                    case "Circle":
                        if(tempPoints.size() == 2){
                            double pointDistance = Math.abs(Math.sqrt(Math.pow(tempPoints.get(1).getX() - tempPoints.get(0).getX(),2) +
                                    Math.pow(tempPoints.get(1).getY() - tempPoints.get(0).getY(),2)));
                            int x = (int) (tempPoints.get(0).x - pointDistance);
                            int y = (int) (tempPoints.get(0).y - pointDistance);
                            // pointDistance is radius, we need diameter
                            shapes.add(new CircleShape(new Point(x,y), (int)pointDistance * 2, currentColour,
                                    currentStrokeSize));
                            tempPoints.clear();
                        }
                        break;
                    case "Triangle":
                        if(tempPoints.size()== 3){
                            shapes.add(new TriangleShape(tempPoints.get(0), tempPoints.get(1), tempPoints.get(2),
                                    currentColour, currentStrokeSize));
                            tempPoints.clear();
                        }
                        break;
                    case "Square":
                        if(tempPoints.size() == 2){
                            shapes.add(new SquareShape(tempPoints.get(0),tempPoints.get(1), currentColour, currentStrokeSize));
                            tempPoints.clear();
                        }
                        break;
                    case "Star":
                        if(tempPoints.size() == 2){
                            shapes.add(new StarShape(tempPoints.get(0), tempPoints.get(1), currentColour, currentStrokeSize));
                            tempPoints.clear();
                        }
                        break;

                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(new RenderingHints(KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));
//        g2d.set

        // initially drawn within a switch, moved draw functionality into the shapes themselves
        for (Shape shape: shapes){
            g2d.setStroke(new BasicStroke(shape.getStrokeSize()));
            g2d.setColor(shape.getColour());
            shape.draw(g2d);
        }

        g2d.setColor(currentColour);
        g2d.setStroke(new BasicStroke(currentStrokeSize));

        // Draw temporary shapes/points
        if(tempPoints.size() > 0){
            switch(currentShape){
                case "Line":
                    g2d.setColor(currentColour);
                    g2d.drawLine(tempPoints.get(0).x, tempPoints.get(0).y, currentHoverPoint.x, currentHoverPoint.y);
                    break;

                case "Circle":
                    g2d.setColor(currentColour);
                    double pointDistance = Math.abs(Math.sqrt(Math.pow(currentHoverPoint.x - tempPoints.get(0).getX(),2) +
                            Math.pow(currentHoverPoint.y - tempPoints.get(0).getY(),2)));

                    int x = (int) (tempPoints.get(0).x - pointDistance );
                    int y = (int) (tempPoints.get(0).y - pointDistance);
                    // pointDistance is radius, we need diameter
                    g2d.drawOval(x,y, (int)pointDistance * 2, (int)pointDistance * 2);
                    break;

                case "Triangle":
                    g2d.setColor(currentColour);
                    if(tempPoints.size() == 1){
                        g2d.drawLine(tempPoints.get(0).x, tempPoints.get(0).y, currentHoverPoint.x, currentHoverPoint.y);

                    }
                    else{
                        g2d.drawLine(tempPoints.get(0).x, tempPoints.get(0).y, tempPoints.get(1).x, tempPoints.get(1).y);
                        g2d.drawLine(tempPoints.get(0).x, tempPoints.get(0).y, currentHoverPoint.x, currentHoverPoint.y);
                        g2d.drawLine(tempPoints.get(1).x, tempPoints.get(1).y, currentHoverPoint.x, currentHoverPoint.y);

                    }
                    break;

                case "Square":
                    g2d.setColor(currentColour);
                    if(tempPoints.size() == 1){
                        double distance = Point.distance(currentHoverPoint.x, currentHoverPoint.y,tempPoints.get(0).x, tempPoints.get(0).y);
                        double slope = (currentHoverPoint.getY() - tempPoints.get(0).getY()) / (currentHoverPoint.getX() - tempPoints.get(0).getX());
                        double rotation = -1 * Math.atan((0 - slope) / 1 + (0 * slope));

                        AffineTransform oldTransform = g2d.getTransform();


                        if(tempPoints.get(0).getX() < currentHoverPoint.getX()){
                            AffineTransform affineTransform = AffineTransform.getRotateInstance(rotation,
                                    tempPoints.get(0).getX(),tempPoints.get(0).getY());

                            g2d.setTransform(affineTransform);
                            g2d.drawRect(tempPoints.get(0).x, tempPoints.get(0).y, (int)distance,(int)distance);
                        }
                        else{
                            AffineTransform affineTransform = AffineTransform.getRotateInstance(rotation,
                                    currentHoverPoint.getX(),currentHoverPoint.getY());
                            g2d.setTransform(affineTransform);

                            g2d.drawRect(currentHoverPoint.x, currentHoverPoint.y, (int)distance,(int)distance);

                        }
                        g2d.setTransform(oldTransform);
                    }

                    break;

                case "Star":
                    if(tempPoints.size() == 1){
                        double distance = Point.distance(currentHoverPoint.x, currentHoverPoint.y,
                                tempPoints.get(0).x, tempPoints.get(0).y);
                        double slope = (currentHoverPoint.getY() - tempPoints.get(0).getY()) /
                                (currentHoverPoint.getX() - tempPoints.get(0).getX());

                        Point oldPoint = currentHoverPoint;
                        Point newPoint;

                        AffineTransform oldTransform = g2d.getTransform();
                        double rotation = -1 * Math.atan((0 - slope) / 1 + (0 * slope));

                        AffineTransform affineTransform = AffineTransform.getRotateInstance(rotation,
                                tempPoints.get(0).getX(),tempPoints.get(0).getY());

                        g2d.setTransform(affineTransform);


                        g2d.drawLine(tempPoints.get(0).x, tempPoints.get(0).y, oldPoint.x, oldPoint.y);

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
                    break;
            }
        }
        repaint();
    }

    public void resetCanvas() {
        shapes.clear();
        repaint();
    }

    public void removeLastShape(){
        if(shapes.size() > 0){
            shapes.remove(shapes.size()-1);
            repaint();
        }
    }

    // Getters & Setters
    public void setCurrentColour(Color colour){
        currentColour = colour;
    }
    public void setCurrentShape(String shape){
        currentShape = shape;
        //on new shape dump old points
        tempPoints.clear();
    }
    public List<Shape> getShapes() {
        return shapes;
    }
    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }
}

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by C12508463 on 28/10/2016.
 *
 * Button to select circle shape
 */
public class CircleButton extends JButton{
    CircleButton() {
        setText("Circle");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                ((Canvas)getParent().getParent().getComponent(1)).setCurrentShape(getText());
            }
        });
    }
}
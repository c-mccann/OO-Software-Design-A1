import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by C12508463 on 28/10/2016.
 */
public class UndoButton extends JButton{
    UndoButton(){
        setText("Undo");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                ((Canvas) getParent().getParent().getComponent(1)).removeLastShape();
            }
        });
    }

}

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by carlmccann2 on 26/10/2016.
 */
public class ResetButton extends JButton{

    ResetButton(){
        setText("Reset");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to reset the canvas?",
                        "Reset", JOptionPane.YES_NO_OPTION);
                if(choice == 0){
                    ((Canvas) getParent().getParent().getComponent(1)).resetCanvas();
                }
            }
        });
    }
}

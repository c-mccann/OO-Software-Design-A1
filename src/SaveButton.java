import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;


/**
 * Created by carlmccann2 on 26/10/2016.
 */
public class SaveButton extends JButton{
    String fileName = "src/bin/shape_state.bin";

    SaveButton(){
        setText("Save");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                Canvas tempCanvas = ((Canvas)getParent().getParent().getComponent(1));
                try {
                    FileOutputStream fos = new FileOutputStream(fileName);
                    BufferedOutputStream buffer = new BufferedOutputStream(fos);
                    ObjectOutputStream out = new ObjectOutputStream(buffer);

                    out.writeObject(tempCanvas.getShapes());
                    out.close();
                    buffer.close();
                    fos.close();

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.List;

/**
 * Created by carlmccann2 on 26/10/2016.
 */
public class LoadButton extends JButton{
    String fileName = "src/bin/shape_state.bin";

    LoadButton(){
        setText("Load");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                Canvas tempCanvas = ((Canvas)getParent().getParent().getComponent(1));

                try{
                    FileInputStream fis = new FileInputStream(fileName);
                    BufferedInputStream buffer = new BufferedInputStream(fis);
                    ObjectInputStream in = new ObjectInputStream(buffer);
                    tempCanvas.setShapes((List<Shape>)in.readObject());

                    in.close();
                    buffer.close();
                    fis.close();

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }



}

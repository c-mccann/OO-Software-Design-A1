import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;


/**
 * Created by carlmccann2 on 26/10/2016.
 */
public class SavePictureButton extends JButton{

    SavePictureButton(){
        setText("Save Picture");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                Canvas tempCanvas = ((Canvas)getParent().getParent().getComponent(1));

                BufferedImage img = new BufferedImage(tempCanvas.getWidth(), tempCanvas.getHeight(), BufferedImage.TYPE_INT_RGB);
                tempCanvas.print(img.getGraphics());
                String fileName = JOptionPane.showInputDialog("Please enter filename:");
                try{
                    ImageIO.write(img, "jpg", new File("src/saves/" + fileName + ".jpg"));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
    }
}

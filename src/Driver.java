import javax.swing.*;
import java.awt.*;

/**
 * Created by C12508463 on 26/10/2016.
 */
public class Driver extends JFrame {

    public Driver(){
        super("Drawing Pad");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setContentPane(createContentPane());
        setVisible(true);
    }
    private Container createContentPane(){
        Container pane = new JPanel(new BorderLayout());

        // setup menu bar
        OptionsMenuBar menu = new OptionsMenuBar();
        pane.add(menu,  BorderLayout.NORTH);
        // setup canvas

        Canvas canvas = new Canvas();
        pane.add(canvas, BorderLayout.CENTER);


        return pane;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Driver();
            }
        });
    }
}

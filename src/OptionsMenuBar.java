import javax.swing.*;

/**
 * Created by C12508463 on 26/10/2016.
 */
public class OptionsMenuBar extends JMenuBar {

    OptionsMenuBar(){
        add(new LineButton());
        add(new CircleButton());
        add(new TriangleButton());
        add(new SquareButton());
        add(new StarButton());

        add(new ColourPickerComboBox());

        add(new UndoButton());
        add(new ResetButton());
        add(new SaveButton());
        add(new LoadButton());
        add(new SavePictureButton());

    }
}

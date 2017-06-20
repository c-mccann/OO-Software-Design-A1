import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * Created by C12508463 on 28/10/2016.
 */
public class ColourPickerComboBox extends JComboBox implements ItemListener{
    String[] colours = {"Black", "White", "Red", "Orange","Yellow","Green","Blue","Indigo","Violet","Pink","Brown","Grey"};
    ColourPickerComboBox(){
        for(String colour: colours){
            addItem(colour);
        }
        addItemListener(this);
    }

    // sends new colours to canvas
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        String colourId = itemEvent.getItem().toString();
        Color colour = Color.BLACK;

        switch(colourId){
            case "Black":
                colour = Color.BLACK;
                break;
            case "White":
                colour = Color.WHITE;
                break;
            case "Red":
                colour = Color.RED;
                break;
            case "Orange":
                colour = Color.ORANGE;
                break;
            case "Yellow":
                colour = Color.YELLOW;
                break;
            case "Green":
                colour = Color.GREEN;
                break;
            case "Blue":
                colour = Color.BLUE;
                break;
            case "Indigo":
                colour = new Color(75,0,130);
                break;
            case "Violet":
                colour = new Color(238,130,238);
                break;
            case "Pink":
                colour = Color.PINK;
                break;
            case "Brown":
                colour = new Color(165,42,42);
                break;
            case "Grey":
                colour = Color.GRAY;
                break;
        }

        ((Canvas)getParent().getParent().getComponent(1)).setCurrentColour(colour);
    }
}

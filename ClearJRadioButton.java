import javax.swing.*;
import java.awt.*;

public class ClearJRadioButton extends JRadioButton {
    Font font1 = new Font("Ariel", Font.BOLD, 20);
    public ClearJRadioButton(String text){
        super.setFont(font1);
        super.setText(text);
        super.setForeground(Color.white);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
    }
}

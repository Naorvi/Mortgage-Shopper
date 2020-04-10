import javax.swing.*;
import java.awt.*;

public class ClearJButton extends JButton {

    public ClearJButton(String text){
        super.setPreferredSize(new Dimension(200, 50));
        super.setText(text);
        super.setForeground(Color.white);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
    }
}

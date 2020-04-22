import javax.swing.*;
import java.awt.*;

public class ClearJButton extends JButton {
    Font font1 = new Font("Ariel", Font.BOLD, 20);
    public ClearJButton(String text){
        super.setPreferredSize(new Dimension(200, 50));
        super.setText(text);
        super.setForeground(Color.white);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFont(font1);
    }
}

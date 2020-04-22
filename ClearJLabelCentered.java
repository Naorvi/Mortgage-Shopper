import javax.swing.*;
import java.awt.*;

public class ClearJLabelCentered extends JLabel {
    Font font1 = new Font("Ariel", Font.BOLD, 20);
    public ClearJLabelCentered(String text){
        super.setPreferredSize(new Dimension(335,20));
        super.setText(text);
        super.setFont(font1);
        super.setForeground(Color.white);
        super.setMinimumSize(new Dimension(200, 10));
        super.setHorizontalTextPosition(JLabel.RIGHT);
    }
}

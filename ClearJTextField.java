import javax.swing.*;
import java.awt.*;

public class ClearJTextField extends JTextField {
    Font font1 = new Font("Ariel", Font.BOLD, 20);
    public ClearJTextField(int col){
        super.setColumns(col);
        super.setFont(font1);
        super.setForeground(Color.white);
        super.setOpaque(false);
        super.setMinimumSize(new Dimension(200, 10));
    }
}

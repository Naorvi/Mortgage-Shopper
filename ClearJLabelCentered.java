import javax.swing.*;
import java.awt.*;

public class ClearJLabelCentered extends ClearJLabel {

    public ClearJLabelCentered(String text){
        super(text);
        super.setPreferredSize(new Dimension(120,20));
        super.setMinimumSize(new Dimension(200, 10));
        super.setHorizontalTextPosition(JLabel.CENTER);
    }
}

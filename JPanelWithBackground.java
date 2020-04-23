import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.lang.String;
import java.net.URL;

public class JPanelWithBackground extends JPanel {
    private Image backgroundImage;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 800);
    }

    public JPanelWithBackground(String fileName) throws IOException {
        backgroundImage = ImageIO.read(new File(fileName));
    }
    public JPanelWithBackground(URL image)throws IOException {
        backgroundImage = ImageIO.read(image);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);
    }
}

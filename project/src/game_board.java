
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.ImageIO;

public class game_board extends JEditorPane {
    Image background;
    Image test;
    JLabel lbl;

    public game_board() {
        try {
            background = Toolkit.getDefaultToolkit().createImage("./images/Background1.jpg");
            test=Toolkit.getDefaultToolkit().createImage("./images/Advancing_zombie.gif");
        } catch (Exception e) {
            System.out.println("fail to load image");
        }

        this.setPreferredSize(new Dimension());

        this.setDragEnabled(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);

        for (int y = 89; y < 580; y += 95) {
            //	g.drawLine(260, y, 970, y);
            for (int x = 260; x < 1000; x += 80) {
                //		g.drawLine(x, 89, x, 570);
            }
        }
        //	g.drawImage(this.test, Main_view.WINDOWS_WIDTH/2,100,null);
        repaint();

    }
}

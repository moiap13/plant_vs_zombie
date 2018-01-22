
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.ImageIO;

public class game_board extends JPanel {
    Image background;
    Image test;
    JLabel lbl;

    public game_board() {

        try {
            background = Toolkit.getDefaultToolkit().createImage("./images/Background1.png");
        } catch (Exception e) {
            System.out.println("fail to load image");
        }

        this.setPreferredSize(new Dimension(1000,429));
        this.setTransferHandler(new MyTransferHandler());
        //this.setDragEnabled(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //repaint();
    }

    public void draw_img(drawable d)
    {
        d.draw(this.getGraphics(), null);
    }

    /*

    public void draw_background()
    {
        p.draw(this.getGraphics(), null);
    }

    public void draw_plant(plant p)
    {
        p.draw(this.getGraphics(), null);
    }

    */
}

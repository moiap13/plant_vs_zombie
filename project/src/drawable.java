import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class drawable extends JLabel{
    protected Image img;
    protected position pos;
    protected String img_path;

    public void draw(Graphics g, ImageObserver io){
        g.drawImage(img, this.pos.getX(), this.pos.getY(), io);
    }

    public void create_image()
    {
        img = new ImageIcon(img_path).getImage();
    }
}

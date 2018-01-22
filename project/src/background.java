import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class background extends drawable {

    public background()
    {
        this.img = new ImageIcon(game.BACKGROUND_IMG_PATH).getImage();
        this.pos = new position(0,0);
    }
}

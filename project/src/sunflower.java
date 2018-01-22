import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class sunflower extends plant{

    public sunflower(position pos)
    {
        this.pos = pos;

        this.life_point = PV;
        this.pos = pos;
        this.img_path = game.img_path[0][1];
        create_image();
    }

    public void create_sun()
    {
        sun s = new sun(this.pos);
    }

    private static final int PV = 10;
}
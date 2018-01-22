import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class plant extends drawable {

    public plant(int lp, position pos)
    {
        this.life_point = lp;
        this.pos = pos;
        this.hit_box = new Rectangle((int)pos.getX(), (int)pos.getY(), /*(int)pos.getX()+*/this.WIDTH, /*(int)pos.getY() + */this.HEIGHT);
    }

    public plant(int lp, position pos, String img_path)
    {
        this.life_point = lp;
        this.pos = pos;
        this.hit_box = new Rectangle((int)pos.getX(), (int)pos.getY(), /*(int)pos.getX()+*/this.WIDTH, /*(int)pos.getY() + */this.HEIGHT);
        this.img_path = img_path;
        create_image();
    }

    public plant(plant p)
    {
        this.life_point = p.life_point;
        this.pos = p.pos;
        this.hit_box = p.hit_box;
        this.img_path = p.img_path;
        create_image();
    }

    public position getPos() { return this.pos; }

    protected static final int WIDTH = 100;
    protected static final int HEIGHT = 100;

    public int life_point;
    protected Rectangle hit_box;

    public plant() {
    }
}
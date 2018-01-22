import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class zombie extends drawable{

    // Constructors
    public zombie() {}
    /*public zombie(int pv, int speed, position pos)
    {
        life_point = pv;
        this.speed = speed;
        this.pos = pos;
    }

    public zombie(int pv, int speed, int pos_x, int pos_y)
    {
        life_point = pv;
        this.speed = speed;
        this.pos = new position(pos_x, pos_y);
    }
    */
    public zombie(zombie z)
    {
        this.life_point = z.life_point;
        this.speed = z.speed;
        this.pos = z.pos;
        this.hit_box = z.hit_box;
        this.img_path = z.img_path;
        create_image();
    }

    public void walk()
    {
        if(can_walk)
            pos.setX( pos.getX() - speed);
        else
            System.out.println("YEAH!!");
    }

    public void test()
    {
        this.hit_box.setBounds(this.pos.getX(), this.pos.getY(), 120, 160);
    }

    public int getLife_point() {
        return life_point;
    }

    public int getSpeed() {
        return speed;
    }

    public position getPos() {
        return pos;
    }

    public String getImg_path() { return this.img_path; }

    public void setLife_point(int life_point) {
        this.life_point = life_point;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setPos(position pos) {
        this.pos = pos;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public int life_point;
    protected int speed;
    public Rectangle hit_box;
    public boolean can_walk = true;
    public static final int DAMMAGE = 1;
}
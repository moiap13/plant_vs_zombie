public class zombie {

    // Constructors

    public zombie(int pv, int speed, position pos)
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


    public void walk()
    {
        pos.setX( pos.getX() - speed);
    }


    //Getter and setter
    public int getLife_point() {
        return life_point;
    }

    public int getSpeed() {
        return speed;
    }

    public position getPos() {
        return pos;
    }

    public void setLife_point(int life_point) {
        this.life_point = life_point;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setPos(position pos) {
        this.pos = pos;
    }



    private int life_point;
    private int speed;
    private position pos;
}
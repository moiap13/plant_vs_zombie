public class pea extends drawable{
    public pea(position pos)
    {
        this.pos = pos;
        this.img_path = "./images/ProjectilePea.png";
        create_image();
        game.array_pea.add(this);
    }

    public pea() {
    }

    public void moove()
    {
        this.pos = new position(this.pos.getX() + this.SPEED, this.pos.getY());
    }

    public position getPos() { return pos; }
    public void setPosition(position pos) { this.pos = pos; }

    private static final int SPEED = 5;

    public int getDammage() { return this.dammage; }

    private int dammage = 1;
}

public class pea_shooter extends plant{
    public pea_shooter(position pos, int line)
    {
        this.pos = pos;

        this.life_point = PV;
        this.pos = pos;
        this.img_path = game.img_path[1][1];
        create_image();
        this.line = line;
    }

    public void shoot()
    {
        pea p = new pea(this.pos);
    }

    private static final int PV = game.life_point_table[1];
    public int line;
}

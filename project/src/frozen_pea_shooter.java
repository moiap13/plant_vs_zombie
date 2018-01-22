public class frozen_pea_shooter extends plant{
    public frozen_pea_shooter(position pos, int line)
    {
        this.pos = pos;

        this.life_point = PV;
        this.pos = pos;
        this.img_path = game.img_path[2][1];
        create_image();
        this.line = line;
    }

    public void shoot()
    {
        frozen_pea p = new frozen_pea(this.pos);
    }

    private static final int PV = game.life_point_table[2];
    public int line;
}

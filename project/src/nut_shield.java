public class nut_shield extends plant {
    public nut_shield(position pos)
    {
        this.pos = pos;

        this.life_point = PV;
        this.pos = pos;
        this.img_path = game.img_path[3][1];
        create_image();
    }

    private static final int PV = game.life_point_table[3];
}

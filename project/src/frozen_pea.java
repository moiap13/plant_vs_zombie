public class frozen_pea extends pea {
    public frozen_pea(position pos){
        this.pos = pos;
        this.img_path = "./images/ProjectileSnowPea.png";
        create_image();
        game.array_pea.add(this);
    }

    public int getDammage() { return this.dammage; }

    private int dammage = 2;
}

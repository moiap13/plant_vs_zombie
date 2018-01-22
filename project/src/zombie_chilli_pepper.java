import javax.swing.*;

public class zombie_chilli_pepper extends zombie {

    public zombie_chilli_pepper(position pos)
    {
        this.life_point = PV;
        this.speed = SPEED;
        this.pos = pos;
        this.img_path = IMG_ZOMBIE;
        this.img = new ImageIcon(img_path).getImage();
    }

    public zombie_chilli_pepper(int pv, int speed, int pos_x, int pos_y)
    {
        this.life_point = pv;
        this.speed = speed;
        this.pos.setX(pos_x);
        this.pos.setY(pos_y);
        this.img_path = IMG_ZOMBIE;

        this.draw(game.game_board.getGraphics(), null);
    }

    private static final int PV = 10;
    private static final int SPEED = 5;
    private static final String IMG_ZOMBIE = "./images/zombie_chilli_pepper.gif";
}

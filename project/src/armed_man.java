import javax.swing.*;

public class armed_man extends zombie{

        public armed_man(position pos)
        {
            this.life_point = PV;
            this.speed = SPEED;
            this.pos = pos;
            this.img_path = IMG_ZOMBIE;
            this.img = new ImageIcon(img_path).getImage();
        }

        public armed_man(int pv, int speed, int pos_x, int pos_y)
        {
            this.life_point = pv;
            this.speed = speed;
            this.pos.setX(pos_x);
            this.pos.setY(pos_y);
            this.img_path = IMG_ZOMBIE;

            this.draw(game.game_board.getGraphics(), null);
        }

        private static final int PV = 10;
        private static final int SPEED = 10;
        private static final String IMG_ZOMBIE = "./images/armed_man.gif";
}

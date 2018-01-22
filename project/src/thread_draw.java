import javax.swing.*;
import java.awt.*;

public class thread_draw extends Thread {
    public thread_draw() {
    }

    @Override
    public void run() {

        info_lbl nb_arra = new info_lbl("size_zombie");
        game.menu.add(nb_arra);
       while (game.game_running)
       {
           game.game_board.draw_img(game.background);



           if (game.array_plant.size() > 0) {
               for (int i = 0; i < game.array_plant.size(); i++) {
                   game.game_board.draw_img(game.array_plant.get(i));
               }
           }

           if (game.array_zombie.size() > 0) {
               for (int i = 0; i < game.array_zombie.size(); i++) {
                   game.game_board.draw_img(game.array_zombie.get(i));
               }
           }

           if (game.array_sun.size() > 0) {
               for (int i = 0; i < game.array_sun.size(); i++) {
                   game.game_board.draw_img(game.array_sun.get(i));
               }
           }

           if (game.array_pea.size() > 0) {
               for (int i = 0; i < game.array_pea.size(); i++) {
                   game.game_board.draw_img(game.array_pea.get(i));
               }
           }

            nb_arra.setText(String.valueOf(game.array_sun.size()));

           try {
               Thread.sleep(100);
           }catch(InterruptedException e){
               e.printStackTrace();
           }

       }

    }
}
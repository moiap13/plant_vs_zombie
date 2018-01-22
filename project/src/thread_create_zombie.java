import java.util.Random;

public class thread_create_zombie extends Thread {
    Random rand;
    public thread_create_zombie() {
        rand = new Random();
    }

    @Override
    public void run() {
        while (game.game_running)
        {
            int zombie_type = rand.nextInt(3);
            int line = rand.nextInt(game.NB_CELL_V);
            position pos = new position(game.ZOMBIE_INIAL_X, (int)game.grid_point[0][line].getY());
            game.array_zombie.add(new zombie(get_zombie(zombie_type, pos)));

            try {
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }

    }

    private zombie get_zombie(int i, position pos)
    {
        zombie z;
        switch (i)
        {
            case 0:
                z = new zombie_simple(pos);
                break;
            case 1:
                z = new zombie_chilli_pepper(pos);
                break;
            case 2:
                z = new armed_man(pos);
                break;
            default:
                z = null;
                break;
        }
        return z;
    }
}
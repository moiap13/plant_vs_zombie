public class thread_shoot extends Thread {
    public thread_shoot() {}

    private int count=0;
    @Override
    public void run()
    {
        while (game.game_running)
        {
            if (game.array_plant.size() > 0) {
                if (count >= 10) {
                    for (int i = 0; i < game.array_plant.size(); i++) {
                        plant p = game.array_plant.get(i);
                        if (p instanceof pea_shooter) {
                            //if(game.zombie_on_line[((pea_shooter) p).line])
                                ((pea_shooter) p).shoot();
                        }
                        else if (p instanceof frozen_pea_shooter) {
                            //if(game.zombie_on_line[((pea_shooter) p).line])
                            ((frozen_pea_shooter) p).shoot();
                        }
                    }
                    count=0;
                }
            }

            if (game.array_pea.size() > 0) {
                for (int i = 0; i < game.array_pea.size(); i++) {
                    game.array_pea.get(i).moove();
                }
            }

            try {
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            count++;

        }
    }
}

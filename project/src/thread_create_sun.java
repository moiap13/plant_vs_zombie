public class thread_create_sun extends Thread{
    public thread_create_sun() { }

    @Override
    public void run()
    {
        while (game.game_running)
        {
            if (game.array_plant.size() > 0) {
                for (int i = 0; i < game.array_plant.size(); i++) {

                    plant p = game.array_plant.get(i);
                    if (p instanceof sunflower)
                        ((sunflower) p).create_sun();
                }
            }
            try {
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}

public class thread_advancing_zombie extends Thread {
    public thread_advancing_zombie()
    {

    }

    public void run() {

        while (game.game_running) {
            if (game.array_zombie.size() > 0) {
                for (int i = 0; i < game.array_zombie.size(); i++) {
                    game.array_zombie.get(i).walk();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

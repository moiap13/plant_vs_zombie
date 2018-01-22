public class thread_line extends Thread {

    public thread_line(int y, int line)
    {
        this.y = y;
        this.line = line;
    }

    @Override
    public void run() {
        while (game.game_running) {
            for (int i=0;i<game.NB_CELL_V;i++)
                game.zombie_on_line[i] = false;

            if (game.array_zombie.size() > 0) {
                for (int i = 0; i < game.array_zombie.size(); i++) {

                    if (game.array_zombie.get(i).getPos().getY() == this.y) {
                        game.zombie_on_line[line] = true;
                        if (game.array_zombie.get(i).getPos().getX() <= (int) game.INITIAL_POS.getX()-50) {
                            System.out.println("You loose..");
                            System.exit(0);
                        }
                    }
                }
            }

            if (game.array_pea.size() > 0) {
                for (int i = 0; i < game.array_pea.size(); i++) {
                    if (game.array_pea.get(i).getPos().getY() == this.y) {

                        if (game.array_pea.get(i).getPos().getX() >= game.ZOMBIE_INIAL_X)
                            game.array_pea.remove(i);

                        if (game.array_zombie.size() > 0) {
                            for (int y = 0; y < game.array_zombie.size(); y++) {
                                if (game.array_zombie.get(y).getPos().getY() == this.y) {
                                    if (game.array_pea.get(i).getPos().getX() >= game.array_zombie.get(y).getPos().getX()) {
                                        game.array_zombie.get(y).life_point -= game.array_pea.get(i).getDammage();

                                        if (game.array_zombie.get(y).life_point <= 0)
                                            game.array_zombie.remove(y);

                                        game.array_pea.remove(i);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (game.array_zombie.size() > 0) {
                for (int i = 0; i < game.array_zombie.size(); i++) {
                    if (game.array_zombie.get(i).getPos().getY() == this.y) {
                        if (game.array_plant.size() > 0)
                            for (int y = 0; y < game.array_plant.size(); y++)
                                if (game.array_plant.get(y).getPos().getY() == this.y)
                                    if (game.array_zombie.get(i).getPos().getX() <= game.array_plant.get(y).getPos().getX())
                                    {
                                        game.array_zombie.get(i).can_walk = false;
                                        game.array_plant.get(y).life_point -= zombie.DAMMAGE;

                                        if (game.array_plant.get(y).life_point <= 0) {
                                            for (int z=0; z<game.array_zombie.size(); z++)
                                                if (game.array_zombie.get(z).getPos().getX() == game.array_plant.get(y).getPos().getX())
                                                    game.array_zombie.get(z).can_walk = true;

                                            game.array_plant.remove(y);
                                        }
                                    }

                        game.zombie_on_line[line] = true;
                    }
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int y=0;
    private int line=0;

}

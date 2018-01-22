import java.awt.*;
import java.util.ArrayList;

public class game {

    // Constantes variables
    //public static final int WINDOWS_WIDTH = 1000;
    //public static final int WINDOWS_HEIGHT = 546;
    public static final int WINDOWS_WIDTH = 1400;
    public static final int WINDOWS_HEIGHT = 710;
    public static final int DELAY_ZOMBIE = 500;
    public static final int NB_ZOMBIE_PER_WAVE = 5;
    public static final String TITLE="Plant vs Zombie";
    public static final int NB_CELL_H = 9;
    public static final int NB_CELL_V = 5;
    //public static final Point INITIAL_POS = new Point(180, 55); // 32 est le chiffre a ajouter pour que le pointeur soit juste sur la photo 32 = taille de la barre de titre de la fenetre
    public static final position INITIAL_POS = new position(250, 80); // 32 est le chiffre a ajouter pour que le pointeur soit juste sur la photo 32 = taille de la barre de titre de la fenetre
    //public static final int[] DEFAULT_SIZE = {55, 67};
    public static final int[] DEFAULT_SIZE = {80, 100};
    public static final String BACKGROUND_IMG_PATH = "./images/Background1.jpg";
    public static final int ZOMBIE_INIAL_X = 970;
    //public static final int ZOMBIE_INIAL_X = 280;


    // Publics variables
    public static boolean game_running=false;
    public static menu menu;
    public static game_board game_board;
    public static windows windows;
    public static position[][] grid_point;
    public static background background;
    public static Boolean[][] grid_addable;
    public static String[][] img_path;
    public static int drag_x;
    public static int drag_y;
    public static int[] life_point_table;
    public static ArrayList<plant> array_plant ;
    public static ArrayList<zombie> array_zombie ;
    public static ArrayList<sun> array_sun ;
    public static ArrayList<pea> array_pea;
    public static int nb_sun = 200;
    public static int sun_indices=0;
    public static boolean[] zombie_on_line;
    //public static int


    // Private variables
    private thread_line[] lines;


    public game()
    {
        game_running = true;
        menu = new menu();
        game_board = new game_board();
        windows = new windows();
        background = new background();

        grid_point = new position[NB_CELL_H][NB_CELL_V];
        grid_point = initialise_grid_point();
        grid_addable = new Boolean[NB_CELL_H][NB_CELL_V];

        lines = new thread_line[NB_CELL_V];

        for (int i = 0; i<NB_CELL_V;i++)
            lines[i] = new thread_line(grid_point[0][i].getY(), i);

        for (int i = 0; i<NB_CELL_H; i++)
            for (int y=0; y<NB_CELL_V; y++)
                grid_addable[i][y] = true;

        zombie_on_line = new boolean[NB_CELL_V];
        for (int i=0;i<game.NB_CELL_V;i++)
            game.zombie_on_line[i] = false;

        img_path = new String[4][2];
        img_path = initialise_img_path();

        drag_x = -1;
        drag_y = -1;

        life_point_table = initialise_life_point_table();

        array_plant = new ArrayList<>();
        array_zombie = new ArrayList<>();
        array_sun = new ArrayList<>();
        array_pea = new ArrayList<>();
//        Random test_rand = new Random();
//
//        JPanel test = new JPanel();
//
//        for (int i=0;i<NB_CELL_H;i++) {
//            int i_color = test_rand.nextInt(7-1)+1;
//            for (int y = 0; y < NB_CELL_V; y++) {
//                test = new JPanel();
//                test.setBounds(new Dimension((int) grid_point[i][y].getX(), (int) grid_point[i][y].getY()));
//                test.setBackground(test_co(i_color));
//
//            }
//        }


        thread_create_zombie test = new thread_create_zombie();
        test.start();
        thread_draw display = new thread_draw();
        display.start();
        thread_advancing_zombie zombies_walk = new thread_advancing_zombie();
        zombies_walk.start();
        thread_create_sun create_sun = new thread_create_sun();
        create_sun.start();
        thread_shoot pea_shoot = new thread_shoot();
        pea_shoot.start();

        for (int i = 0; i<NB_CELL_V;i++)
            lines[i].start();
    }

    private position[][] initialise_grid_point()
    {
        position[][] p = new position[NB_CELL_H][NB_CELL_V];

        for (int i=0;i<NB_CELL_H;i++)
            for (int y=0; y<NB_CELL_V; y++)
                p[i][y] = new position((int)INITIAL_POS.getX()+DEFAULT_SIZE[0]*i, (int)INITIAL_POS.getY()+DEFAULT_SIZE[1]*y);

        return p;
    }
/*
    private Color test_co(int i)
    {
        switch (i)
        {
            case 0:
                return Color.BLACK;
                break;
            case 1:
                return Color.GRAY;
                break;
            case 2:
                return Color.BLUE;

                break;
            case 3:
                return Color.RED;

                break;
            case 4:
                return Color.GREEN;
            break;
            case 5:
                return Color.CYAN;
            break;
            case 6:
                return Color.MAGENTA;
            break;
            case 7:
                return Color.ORANGE;
            break;
            default:
                return Color.lightGray;
        }
        return Color.lightGray;
    }
*/
    public static String[][] initialise_img_path()
    {
        String[][] s = new String[4][2];

        s[0][0] = "./images/SunflowerSeed.png";
        s[0][1] = "./images/sunflower.gif";

        s[1][0] = "./images/PeashooterSeed.png";
        s[1][1] = "./images/PeaShootera.gif";

        s[2][0] = "./images/SnowPeaCard.png";
        s[2][1] = "./images/Snowpea.png";

        s[3][0] = "./images/WallNut.png";
        s[3][1] = "./images/wall_nut_anim.gif";

        return s;
    }

    public static int[] initialise_life_point_table()
    {
        int[] i = new int[4];

        i[0] = 50;
        i[1] = 100;
        i[2] = i[1];
        i[3] = 150;

        return i;
    }

    private boolean prevent_segmentation_fault()
    {
        return (drag_x > -1 && drag_x < NB_CELL_H) && (drag_y > -1 && drag_y < NB_CELL_V);
    }

    public void add_plant(int ind)
    {
        if (prevent_segmentation_fault()) {
            if (grid_addable[drag_x][drag_y])
            {
                plant p = get_plant(ind, grid_point[drag_x][drag_y], drag_y);
                grid_addable[drag_x][drag_y] = false;
                array_plant.add(p);
            }
        }


    }

    private plant get_plant(int i, position pos, int line)
    {
        plant p;
        switch (i)
        {
            case 0:
                p = new sunflower(pos);
                break;
            case 1:
                p = new pea_shooter(pos, line);
                break;
            case 2:
                p = new frozen_pea_shooter(pos, line);
                break;
            case 3:
                p = new nut_shield(pos);
                break;
            default:
                p = null;
                break;
        }
        return p;
    }

    public static boolean img_exist(String img_path)
    {
        Image img;

        try {
            img = Toolkit.getDefaultToolkit().createImage(img_path);
        } catch (Exception e) {
            img = null;
            System.out.println("fail to load image");
        }

        return img != null;
    }
}

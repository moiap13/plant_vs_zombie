import java.awt.*;
import javax.swing.JFrame;

public class game extends JFrame{
    public static final int WINDOWS_WIDTH = 1400;
    public static final int WINDOWS_HEIGHT =695;
    private static final String TITLE="Plant vs Zombie";

    public game(){
        this.setPreferredSize(new Dimension(this.WINDOWS_WIDTH, this.WINDOWS_HEIGHT));
        //the windows is not sizable
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle(this.TITLE);
        this.getContentPane().add(new menu(), BorderLayout.NORTH);
        //this.getContentPane().add(new game_board(),BorderLayout.CENTER);
        this.add(new game_board(),BorderLayout.CENTER);
        this.setVisible(true);
        this.pack();
    }
}

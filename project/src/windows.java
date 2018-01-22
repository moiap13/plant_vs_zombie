import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import javax.swing.JFrame;

public class windows extends JFrame{

    public windows()
    {
        this.setPreferredSize(new Dimension(game.WINDOWS_WIDTH, game.WINDOWS_HEIGHT));
        //the windows is not sizable
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle(game.TITLE);
        this.getContentPane().add(game.menu, BorderLayout.NORTH);
        this.add(game.game_board,BorderLayout.CENTER);
        this.setVisible(true);
        this.pack();
    }
}

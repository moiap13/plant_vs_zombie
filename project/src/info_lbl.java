
import javax.swing.*;
import java.awt.*;


public class info_lbl extends JLabel {
    private static final String FONT_STYLE="arial";
    private static final int FONT_SIZE=30;

    public info_lbl(String txt) {
        this.setText(txt);
        this.setFont(new Font(FONT_STYLE, Font.BOLD, this.FONT_SIZE));
        this.setPreferredSize(new Dimension(game.WINDOWS_WIDTH/(menu.NB_ELEMENTS+1), menu.BAR_HEIGHT));
        this.setVisible(true);
    }
}

import javax.imageio.ImageIO;
import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



/* see https://stackoverflow.com/questions/13130257/drag-and-move-a-picture-inside-a-jlabel-with-mouseclick
    and https://stackoverflow.com/questions/4274606/how-to-change-cursor-icon-in-java
*/

public class shop_lbl extends JLabel implements MouseListener {
    private static final int DEFAULT_IMAGE_WIDTH = 105;
    public static final int DEFAULT_IMAGE_HEIGHT = 67;
    Cursor custom_cursor;
    private String[][] img_path;
    private int indice;


    public shop_lbl(int ind) {
        indice = ind;
        img_path = game.initialise_img_path();
        this.setPreferredSize(new Dimension(DEFAULT_IMAGE_WIDTH,DEFAULT_IMAGE_HEIGHT));
        this.setIcon(new ImageIcon(img_path[indice][0]));
        this.setCursor(Cursor.getDefaultCursor());
        this.addMouseListener(this);

        this.setTransferHandler(new MyTransferHandler());
    }


    public String getImg_path()
    {
        return img_path[indice][0];
    }

    public String getIndStr() { return String.valueOf(indice); }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


        JComponent lab = (JComponent)e.getSource();
        TransferHandler handle = lab.getTransferHandler();
        handle.exportAsDrag(lab, e, TransferHandler.COPY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        this.setCursor(Cursor.getDefaultCursor());
        System.out.println("relessed");

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {}
}

package view;

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

public class shop_lbl extends JLabel implements MouseListener,MouseMotionListener {
    private static final int DEFAULT_IMAGE_WIDTH = 105;
    public static final int DEFAULT_IMAGE_HEIGHT = 67;
    Cursor custom_cursor;


    public shop_lbl(String background_img_path, String cursor_img_path) {
        this.setPreferredSize(new Dimension(DEFAULT_IMAGE_WIDTH,DEFAULT_IMAGE_HEIGHT));
        this.setIcon(new ImageIcon(background_img_path));
        this.setCursor(Cursor.getDefaultCursor());
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.custom_cursor=Cursor.getDefaultCursor();
        this.custom_cursor=Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(cursor_img_path).getImage(),
                new Point(0,0),
                "custom cursor");
    }
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e){

        // this.setCursor(custom_cursor);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        this.setCursor(custom_cursor);
        System.out.println("pressed");

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

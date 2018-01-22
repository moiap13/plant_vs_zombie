import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class sun extends drawable implements MouseListener{
    private int indice;

    public sun(position pos)
    {
        this.pos = pos;
        this.img_path = "./images/Sun_PvZ.png";
        create_image();

        this.setText("");
        this.setPreferredSize(new Dimension(150,150));
        this.addMouseListener(this);

        this.indice = game.sun_indices;
        game.array_sun.add(this.indice, this);
        game.sun_indices++;
    }

    public int get_indice() { return this.indice; }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.setVisible(false);
        System.out.println("mouse clicked");
        game.array_sun.remove(this.indice);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

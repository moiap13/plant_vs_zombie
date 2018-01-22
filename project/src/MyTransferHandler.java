import javax.imageio.ImageIO;
import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.swing.TransferHandler;


public class MyTransferHandler extends TransferHandler{

    public boolean canImport(TransferHandler.TransferSupport info) {
        return info.isDataFlavorSupported(DataFlavor.stringFlavor);
    }

    public boolean importData(TransferHandler.TransferSupport support){

        //if(!canImport(support))
        //    return false;

        Transferable data = support.getTransferable();

        String str = "";

        try {
            str = (String)data.getTransferData(DataFlavor.stringFlavor);
            int ind = Integer.parseInt(str);

            Point p = support.getDropLocation().getDropPoint();
            game.drag_x = ((int)p.getX()-(int)game.INITIAL_POS.getX())/game.DEFAULT_SIZE[0];
            game.drag_y = ((int)p.getY()-(int)game.INITIAL_POS.getY())/game.DEFAULT_SIZE[1];
            main.jeu.add_plant(ind);
        } catch (UnsupportedFlavorException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //shop_lbl lab = (shop_lbl)support.getComponent();



        return false;
    }

    protected void exportDone(JComponent c, Transferable t, int action){
        //Une fois le drop effectué nous effaçons le contenu de notre JLabel
    }

    protected Transferable createTransferable(JComponent c) {
        //On retourne un nouvel objet implémentant l'interface Transferable
        //StringSelection implémente cette interface,  nous l'utilisons donc

        return new StringSelection(((shop_lbl)c).getIndStr());
    }

    public int getSourceActions(JComponent c) {
        return COPY;
    }
}
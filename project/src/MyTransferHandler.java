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

        System.out.println("je suis la");
        Transferable data = support.getTransferable();

        String str = "";
        //shop_lbl str;

        try {
            str = (String)data.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        game_board lab = (game_board)support.getComponent();

        //shop_lbl lab = (shop_lbl)support.getComponent();
        System.out.println("STR : " + str);
        lab.getGraphics().drawImage(Toolkit.getDefaultToolkit().createImage(str),200, 200, null);

        return false;
    }

    protected void exportDone(JComponent c, Transferable t, int action){
        //Une fois le drop effectué nous effaçons le contenu de notre JLabel
    }

    protected Transferable createTransferable(JComponent c) {
        //On retourne un nouvel objet implémentant l'interface Transferable
        //StringSelection implémente cette interface,  nous l'utilisons donc

        System.out.println(((shop_lbl)c).getImg_path());
        return new StringSelection(((shop_lbl)c).getImg_path());
    }

    public int getSourceActions(JComponent c) {
        return COPY;
    }
}
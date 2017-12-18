import view.shop_lbl;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.soap.Text;

public class menu extends JPanel {
    private static final int BAR_WIDTH = game.WINDOWS_WIDTH;
    public static final int BAR_HEIGHT = 85;
    public static final int NB_ELEMENTS = 5;




    public menu(){
        this.setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));


        this.add(new info_lbl("Score"));
        this.add(new shop_lbl("./images/SunflowerSeed.png","./images/sunflower.png"));
        this.add(new info_lbl("Money"));
	/*
		plant1 = new JLabel("plant_1");
		plant1.setPreferredSize(new Dimension(this.BAR_WIDTH/6,BAR_HEIGHT));
		plant2 = new JLabel("plant_2");
		plant2.setPreferredSize(new Dimension(this.BAR_WIDTH/6,BAR_HEIGHT));
		plant3 = new JLabel("plant_3");
		plant3.setPreferredSize(new Dimension(this.BAR_WIDTH/6,BAR_HEIGHT));
		this.add(plant1);
		this.add(plant2);BorderLayout
		this.add(plant3);*/





    }

}

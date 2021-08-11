package com.userView;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.*;

public class IndexPage extends JPanel {

    public IndexPage(){
        Dimension jpanSize = new Dimension(450, 600);
        setPreferredSize(jpanSize);
        setLocation(0, 0);
        setLayout(null);
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Font        f1  = new Font("SansSerif", Font.BOLD,40);
        FontMetrics f1m = g.getFontMetrics(f1);
        
        g.setFont(f1);
        g.setColor(Color.BLACK);
        System.out.println("jpannel size:" + getSize());
        g.drawString("HEY!! Welcome", 50, 110);
          
    }
}

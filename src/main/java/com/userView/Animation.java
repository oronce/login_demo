package com.userView;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/**
 * anime JLabel components
 *
 */
public class Animation{

    public JLabel label;
    public JPanel pannel;

    Animation(JPanel pannel,JLabel label){
        this.label = label;
        this.pannel = pannel;
    }

    public  void animeConstraintLabel() {
        final int UPDATE_RATE = 30;
        Thread doAnimeConstraintLabel = new Thread() {
            
            public void run()
            {
                
                double labelXPosition = label.getLocation().getX();
                int newlabelXPosition = (int)labelXPosition;
                while (newlabelXPosition < labelXPosition+5) {
                    ++newlabelXPosition;
                    //System.out.println(newlabelXPosition + "\n");
                    label.setBounds(newlabelXPosition, 260, 280, 100);
                    pannel.repaint();
                    try {
                    	Toolkit.getDefaultToolkit().sync();
                        Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
                    } catch (InterruptedException ex) { }
                }

                while (newlabelXPosition > labelXPosition) {
                    --newlabelXPosition;
                    //System.out.println(newlabelXPosition + "\n");
                    label.setBounds(newlabelXPosition, 260, 280, 100);
                    pannel.repaint();
                    try {
                    	Toolkit.getDefaultToolkit().sync();
                        Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
                    } catch (InterruptedException ex) { }
                }
               
            }
        };
        doAnimeConstraintLabel.start();
    }

}
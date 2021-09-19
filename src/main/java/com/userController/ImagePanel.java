package com.userController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Painter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

import java.awt.*;

import com.userView.Utilities;

/**
 * it's for test some event firing by listeners
 *
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private static String fileName ="/home/rocee/Pictures/zullScreenshot0.png";

    public static void main(String[] arguments) throws IOException {
 
        JPanel panel = new JPanel();
     
        BufferedImage image = ImageIO.read(new File(fileName));
        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);
     
        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("JPanel Example");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        // add the Jpanel to the main window
        frame.add(panel); 
     
        frame.pack();
        
        frame.setVisible(true);

        for (int i = 0; i < 1000; i++) { 
            fileName = "/home/rocee/Pictures/zullScreenshot" + i + ".png";
             image = ImageIO.read(new File(fileName));
             label = new JLabel(new ImageIcon(image));
             panel.add(label);
            panel.repaint();
            frame.repaint();
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
     
      }}

}

/* for (int i = 0; i < 1000; i++) { 
            imageFileName = "/home/rocee/Pictures/zullScreenshot" + i + ".png";
            m.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }  */
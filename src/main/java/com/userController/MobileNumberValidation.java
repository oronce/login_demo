package com.userController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

import java.awt.*;

import com.userView.Utilities;

public class MobileNumberValidation extends JFrame {

    private JButton clearButton ;
    private JTextField mobileNumberField ;
    private JLabel mobileNumberLabel ;
    private JLabel errorMessage ;
    private DocumentListener validatePhoneListener;

    MobileNumberValidation(){

       

        //Intializing the instance variables
        clearButton  = new JButton("clear");
        mobileNumberField     = new JTextField();
        mobileNumberLabel     = new JLabel("Tel");
        errorMessage = new JLabel("Tel is empty");

        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //add components to Jframe
        add(mobileNumberField);
        add(clearButton);
        add(mobileNumberLabel);
        add(errorMessage);


        //set components location
        mobileNumberField.setBounds(200, 170, 230, 20);
        clearButton.setBounds(200, 220, 100, 20);
        mobileNumberLabel.setBounds(160, 170, 100, 20);
        errorMessage.setBounds(210, 190, 300,20);


        //components style
        errorMessage.setForeground(Color.decode("#CD5C5C"));

        //add listener and handle event
            validatePhoneListener = new DocumentListener(){
            
            @Override
            public void changedUpdate(DocumentEvent arg0) {                
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                processTelValidation();
            }

            @Override
            public void removeUpdate(DocumentEvent event) {
                System.out.println("removeUpdate");
                processTelValidation();
            }

            public void processTelValidation() {
                if (Utilities.isRegExPatternMatching("^0[0-9]{6}$", mobileNumberField.getText())) {
                    errorMessage.setVisible(false);
                }else{
                    errorMessage.setVisible(true);
                    errorMessage.setText("enter a valid Tel number");
                }
            }
            
        };

        mobileNumberField.getDocument().addDocumentListener(validatePhoneListener);

        clearButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //clear telfield
                mobileNumberField.getDocument().removeDocumentListener(validatePhoneListener);
                mobileNumberField.setText("");
                mobileNumberField.getDocument().addDocumentListener(validatePhoneListener);
            }
        });

    }

    public static void main(String[] args) {
        
       new MobileNumberValidation();
        
    }

}

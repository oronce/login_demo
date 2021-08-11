package com.userView;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


import java.awt.*;
public class AppView extends JFrame implements ActionListener{

    private IndexPage indexPage ;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JCheckBox showPassword;
    private JButton signUpButton;
    private JButton logInButton;

    public AppView(){

        //load
        indexPage = new IndexPage();
        usernameLabel = new JLabel("Username");
        usernameField = new JTextField();
        passwordLabel = new JLabel("password");
        passwordField = new JPasswordField() ;
        showPassword = new JCheckBox("Show Password");


        //set loacation and size of components
        usernameLabel.setBounds(100, 300, 80, 20);
        usernameField.setBounds(180, 295, 140, 30);
        passwordLabel.setBounds(100, 350, 80, 20);
        passwordField.setBounds(180, 345, 140, 30);
        showPassword.setBounds(180, 375, 150, 30);
       
        //add components to indexPage or conatainer(Pane)
        indexPage.add(usernameLabel);
        indexPage.add(usernameField);
        indexPage.add(passwordLabel);
        indexPage.add(passwordField);
        indexPage.add(showPassword);

        passwordField.setEchoChar('*');

        //build
        setLocation(600, 150);
        setContentPane(indexPage);
        pack();
        setTitle("login_app");
      
       
        setBackground(new Color(122,52,255));
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        System.out.println(usernameLabel.getLocation());
      
        
        
    }

    public void load() {
        IndexPage indexPage = new IndexPage();
        JLabel usernameLabel = new JLabel("Username");

        JButton signUpButton = new JButton("Signup");
        JButton logInButton = new JButton("LogIn");
    }

    public void addComponentsToPane() {
        
    }

    public void setLocationAndSizeOfComponents() {
        
    }

    public void init(){
       
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
       
        
    }
}

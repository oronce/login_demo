package com.userView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

import java.awt.*;
public class AppView extends JFrame implements ActionListener,MouseListener{

    private IndexPage      indexPage ;
    private JLabel         usernameLabel;
    private JTextField     usernameField;
    private boolean        isUsernameValid; 
    private JPasswordField passwordField;
    private JLabel         passwordLabel;
    private JCheckBox      showPasswordCheckBox;
    private JButton        logInButton;
    private JButton        signUpButton;
    private JLabel         textLabel;
    private JLabel         signUpHyperlinkLabel;
    private JLabel         logInHyperlinkLabel;
    private JLabel         usernameConstraintsLabel;  
    private JLabel         passwordConstraintsLabel;

    public AppView(){

        //load
        indexPage                = new IndexPage();
        usernameLabel            = new JLabel("Username");
        usernameField            = new JTextField();
        passwordLabel            = new JLabel("password");
        passwordField            = new JPasswordField() ;
        showPasswordCheckBox     = new JCheckBox("Show Password");
        logInButton              = new JButton("LogIn");
        signUpButton             = new JButton("SignUp"); 
        textLabel                = new JLabel("Don't have an account?");
        signUpHyperlinkLabel     = new JLabel("SignUp");
        logInHyperlinkLabel      = new JLabel("LogIn");  
        usernameConstraintsLabel = new JLabel("");
        passwordConstraintsLabel = new JLabel("");

        //set loacation and size of components
        usernameLabel.setBounds(70, 270, 80, 20);
        usernameField.setBounds(150, 265, 170, 30);
        passwordLabel.setBounds(70, 350, 80, 20);
        passwordField.setBounds(150, 345, 170, 30);
        showPasswordCheckBox.setBounds(150, 375, 150, 30);
        logInButton.setBounds(70, 420, 100, 30);
        signUpButton.setBounds(70, 420, 100, 30);
        textLabel.setBounds(175, 425, 190, 20);

        usernameConstraintsLabel.setBounds(150, 260, 280, 100);
        

        signUpHyperlinkLabel.setBounds(355, 425, 50, 20);
        logInHyperlinkLabel.setBounds(365, 425, 50, 20);
        

        //add components to indexPage or conatainer(Pane)
        indexPage.add(usernameLabel);
        indexPage.add(usernameField);
        indexPage.add(passwordLabel);
        indexPage.add(passwordField);
        indexPage.add(showPasswordCheckBox);
        indexPage.add(logInButton);
        indexPage.add(textLabel);
        indexPage.add( signUpHyperlinkLabel);
        indexPage.add(usernameConstraintsLabel);

        //Adding Event Handling
        logInButton.addActionListener(this);
        signUpButton.addActionListener(this);
        logInHyperlinkLabel.addMouseListener(this);
        signUpHyperlinkLabel.addMouseListener(this);
        usernameField.addActionListener(this);
        showPasswordCheckBox.addActionListener(this);
        usernameField.getDocument().addDocumentListener(new TextFieldListener(){
            @Override
            public void insertUpdate(DocumentEvent event) {

                isUsernameValid = true;
                System.out.println("\n");
                
                do {
                    if (Pattern.compile("^[a-zA-Z0-9].*$").matcher(usernameField.getText()).matches()) {
                        System.out.println("true for first character must be alphanumeric");
                    }else{
                        
                        isUsernameValid = false;
                        usernameConstraintsLabel.setText("! first character must be alphanumeric");
                        break;
                    }

                    if ( (Pattern.compile("^([\\w])+$").matcher(usernameField.getText()).matches()) ) {
                        System.out.println("true only \"_\" metacharacter is allowed");
                    }else{
                        isUsernameValid = false;
                        usernameConstraintsLabel.setText("only \"_\" metacharacter is allowed");
                        break;
                    }

                    if (Pattern.compile("^.{3,}$").matcher(usernameField.getText()).matches() ) {
                        System.out.println("true at least 3 character");
                    }else{
                        System.out.println("at least 3 character settin to false");
                        isUsernameValid = false;
                        usernameConstraintsLabel.setText("at least 3 character");
                        break;
                    }
                }while (isUsernameValid == false);

                System.out.println("isUserNameValid=" + isUsernameValid);
                if (isUsernameValid) {
                    usernameConstraintsLabel.setVisible(false);
                }else{
                    System.out.println("im hide myself");
                    usernameConstraintsLabel.setVisible(true);
                }

            }

            public void removeUpdate(DocumentEvent event) {

                //no validation for empty string
                if (usernameField.getText().length() == 0) {
                    usernameConstraintsLabel.setText("username is empty");
                    return;
                }

                do {
                    if (Pattern.compile("^[a-zA-Z0-9].*$").matcher(usernameField.getText()).matches()) {
                        System.out.println("true for first character must be alphanumeric");
                    }else{
                        
                        isUsernameValid = false;
                        usernameConstraintsLabel.setText("! first character must be alphanumeric");
                        break;
                    }

                    if ( (Pattern.compile("^([\\w])+$").matcher(usernameField.getText()).matches()) ) {
                        System.out.println("true only \"_\" metacharacter is allowed");
                    }else{
                        isUsernameValid = false;
                        usernameConstraintsLabel.setText("only \"_\" metacharacter is allowed");
                        break;
                    }

                    if (Pattern.compile("^.{3,}$").matcher(usernameField.getText()).matches() ) {
                        System.out.println("true at least 3 character");
                    }else{
                        System.out.println("at least 3 character settin to false");
                        isUsernameValid = false;
                        usernameConstraintsLabel.setText("at least 3 character");
                        break;
                    }
                }while (isUsernameValid == false);

                System.out.println("isUserNameValid=" + isUsernameValid);
                if (isUsernameValid) {
                    usernameConstraintsLabel.setVisible(false);
                }else{
                    System.out.println("im hide myself");
                    usernameConstraintsLabel.setVisible(true);
                }
            }
            
        });




        //test section and addStyleToComponent
        usernameField.setBorder(BorderFactory.createLineBorder(Color.decode("#228B22")));
        passwordField.setEchoChar('*');
        
        

        logInHyperlinkLabel.setForeground(Color.BLUE.darker());
        logInHyperlinkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpHyperlinkLabel.setForeground(Color.BLUE.darker());
        signUpHyperlinkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        usernameConstraintsLabel.setForeground(Color.decode("#CD5C5C"));

        //build
        setLocation(600, 150);
        setContentPane(indexPage);
        pack();
        setTitle("login_app");

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    /* public void load() {
        IndexPage indexPage = new IndexPage();
        JLabel usernameLabel = new JLabel("Username");

        JButton signUpButton = new JButton("Signup");
        JButton logInButton = new JButton("LogIn");
    } */

    public void addComponentsToPane() {
        
    }

    public void setLocationAndSizeOfComponents() {
        
    }

    public void init(){
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == usernameField) {
            System.out.println(true);
        }
      
        if (e.getSource() == logInButton) {
            String userText;
            
            userText = usernameField.getText();
            if(userText.charAt(1)==1);
            System.out.println(userText);
        }

        if(showPasswordCheckBox.isSelected()){
            passwordField.setEchoChar((char)0); 
        }else{
            passwordField.setEchoChar('*');
        }
        
    }

    //mouse listener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == signUpHyperlinkLabel ) {
            indexPage.remove(signUpHyperlinkLabel);
            indexPage.remove(logInButton);
            indexPage.add(logInHyperlinkLabel);
            indexPage.add(signUpButton);
            textLabel.setText("Already have an account?");
            indexPage.repaint();

        }else if ( e.getSource() == logInHyperlinkLabel ){
            indexPage.remove(logInHyperlinkLabel);
            indexPage.remove(signUpButton);
            indexPage.add(signUpHyperlinkLabel);
            indexPage.add(logInButton);
            textLabel.setText("Don't have an account?");
            indexPage.repaint();
            
        }
        System.out.println(e.getSource() == logInHyperlinkLabel);
    }
         

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }
}

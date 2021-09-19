package com.userView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.List;


import com.userController.User;

import org.hibernate.userModel.dbOperations;

import javax.swing.SwingUtilities;

import java.awt.*;

enum PageName{
    LOGIN , SIGNUP
}

public class AppView extends JFrame implements ActionListener,MouseListener{

     
    private IndexPage      indexPage ;
    private PageName       pageName; 
    private JLabel         usernameLabel;
    private JTextField     usernameField;
    private boolean        isUsernameValid; 
    private boolean        isPasswordValid;
    private JPasswordField passwordField;
    private JLabel         passwordLabel;
    private JCheckBox      showPasswordCheckBox;
    private JButton        logInButton;
    private JButton        signUpButton;
    private JLabel         loginOrSignupLabel;  
    private JLabel         textLabel;
    private JLabel         signUpHyperlinkLabel;
    private JLabel         logInHyperlinkLabel;
    private JLabel         usernameErrorValidationMessage;  
    private JLabel         passwordErrorValidationMessage;
    private ImageIcon      showPasswordIcon;
    private JLabel         showPassWordIconJLabel;
    private DocumentListener usernameValidationListener, passwodValidationListener;
    

    public AppView(){

        //Intializing the instance variables
        indexPage                      = new IndexPage();
        usernameLabel                  = new JLabel("Username");
        usernameField                  = new JTextField();
        passwordLabel                  = new JLabel("password");
        passwordField                  = new JPasswordField() ;
        showPasswordCheckBox           = new JCheckBox("");
        logInButton                    = new JButton("LogIn");
        signUpButton                   = new JButton("SignUp"); 
        loginOrSignupLabel             = new JLabel("SignUp");  
        textLabel                      = new JLabel("Don't have an account?");
        signUpHyperlinkLabel           = new JLabel("SignUp");
        logInHyperlinkLabel            = new JLabel("LogIn");  
        usernameErrorValidationMessage = new JLabel("");
        passwordErrorValidationMessage = new JLabel("");
        showPasswordIcon               = new ImageIcon("/home/rocee/project/java_project/login_app/public/show_password.png",
                                         "a pretty but meaningless splat"); 
        showPassWordIconJLabel         = new JLabel("") ;       
        pageName                       =  PageName.SIGNUP;                             
        


        //set loacation and size of components
        usernameLabel.setBounds(70, 270, 80, 20);
        usernameField.setBounds(150, 265, 170, 30);
        passwordLabel.setBounds(70, 350, 80, 20);
        passwordField.setBounds(150, 345, 170, 30);
        showPasswordCheckBox.setBounds(350, 347, 150, 30);

        logInButton.setBounds(70, 430, 100, 30);
        signUpButton.setBounds(70, 430, 100, 30);   
        loginOrSignupLabel.setBounds(15, 150, 250, 100);

        textLabel.setBounds(175, 435, 190, 20);
        signUpHyperlinkLabel.setBounds(355, 435, 50, 20);
        logInHyperlinkLabel.setBounds(365, 435, 50, 20);

        usernameErrorValidationMessage.setBounds(150, 260, 280, 100);
        passwordErrorValidationMessage.setBounds(150, 380, 150, 30);

        showPassWordIconJLabel.setIcon(showPasswordIcon);
        showPassWordIconJLabel.setBounds(320, 314, 100, 100);

        //add components to indexPage or conatainer(Pane)
        indexPage.add(usernameLabel);
        indexPage.add(usernameField);
        indexPage.add(passwordLabel);
        indexPage.add(passwordField);
        indexPage.add(showPasswordCheckBox);
        indexPage.add(signUpButton);
        indexPage.add(textLabel);
        indexPage.add(logInHyperlinkLabel);
        indexPage.add(usernameErrorValidationMessage);
        indexPage.add(passwordErrorValidationMessage);
        indexPage.add(showPassWordIconJLabel);
        indexPage.add(loginOrSignupLabel);
        
        //Adding Event Handling
        logInButton.addActionListener(this);
        signUpButton.addActionListener(this);
        logInHyperlinkLabel.addMouseListener(this);
        signUpHyperlinkLabel.addMouseListener(this);
        usernameField.addActionListener(this);
        MyFocusListener focusListener = new MyFocusListener(this);
        usernameField.addFocusListener(focusListener);
         


        usernameValidationListener = new TextFieldListener(){
            
            @Override
            public void insertUpdate(DocumentEvent event) {
                
                processUsernameValidation();
               
            }

            public void removeUpdate(DocumentEvent event) {
                
                processUsernameValidation();
            }

            private void processUsernameValidation(){
                isUsernameValid = true;
                String userInput = usernameField.getText();
                 //no validation for empty string
                if(usernameField.getText().length() == 0) {
                    isUsernameValid = false;
                    usernameErrorValidationMessage.setText("!! username is empty");
                    if(pageName == PageName.SIGNUP)return;
                }

                //those validation is only for signup form
                if (pageName == PageName.SIGNUP) {
                    
                    //display error once a regex pattern doesn't match input
                    if (Utilities.isRegExPatternMatching("^[a-zA-Z0-9].*$", userInput ) == false ) {
                        isUsernameValid = false;
                        usernameErrorValidationMessage.setText("! first character must be alphanumeric");

                    }else if ( Utilities.isRegExPatternMatching("^([\\w])+$", userInput) == false ) {
                        isUsernameValid = false;
                        usernameErrorValidationMessage.setText("! only \"_\" metacharacter is allowed");

                    }else if (Utilities.isRegExPatternMatching("^.{3,}$", userInput) == false ) {
                        isUsernameValid = false;
                        usernameErrorValidationMessage.setText("! at least 3 character");
                    }
                }

                if (isUsernameValid) {
                    usernameErrorValidationMessage.setVisible(false);
                    usernameField.setBorder(BorderFactory.createLineBorder(Color.decode("#228B22")));
                    
                }else{
                    usernameErrorValidationMessage.setVisible(true);
                    usernameField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4500")));
                }  
            }
            
        };
        passwodValidationListener  = new TextFieldListener(){

            @Override
            public void insertUpdate(DocumentEvent event) {
                processPasswordValidation();
            }
        
            @Override
            public void removeUpdate(DocumentEvent event) {
                //if signup or login link get cliked just clean the field
                processPasswordValidation();
                
            }
            
            private void processPasswordValidation(){
                Runnable doPasswordValidation = new Runnable() {
                    @Override
                    public void run() {
                       isPasswordValid = true;

                       //this occur only for signup page
                       if (pageName == PageName.SIGNUP) {
                            if (passwordField.getPassword().length < 8) {
                                passwordErrorValidationMessage.setText("8 character at least");
                                isPasswordValid = false;
                            }
                       }
                       

                       if (passwordField.getPassword().length == 0 ) { 
                           isPasswordValid = false;
                           passwordErrorValidationMessage.setText("!! password is empty");
                        }

                       if (isPasswordValid) {
                            passwordErrorValidationMessage.setVisible(false);
                            passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#228B22")));
                        }else{
                            passwordErrorValidationMessage.setVisible(true);
                            passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4500")));
                        }
                    }
                };       
                SwingUtilities.invokeLater(doPasswordValidation);
            }
        };

        showPasswordCheckBox.addActionListener(this);
        usernameField.getDocument().addDocumentListener(usernameValidationListener);
        

        passwordField.getDocument().addDocumentListener(passwodValidationListener);

        

        //test section and addStyleToComponent


        loginOrSignupLabel.setFont(new Font("Serif", Font.BOLD, 30));

        usernameField.setBorder(BorderFactory.createLineBorder(Color.decode("#666")));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#666")));

        signUpButton.setForeground(Color.BLACK);
        signUpButton.setBackground(Color.WHITE);
        
        passwordField.setEchoChar('*');

        

        logInHyperlinkLabel.setForeground(Color.BLUE.darker());
        logInHyperlinkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpHyperlinkLabel.setForeground(Color.BLUE.darker());
        signUpHyperlinkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        usernameErrorValidationMessage.setForeground(Color.decode("#CD5C5C"));
        passwordErrorValidationMessage.setForeground(Color.decode("#CD5C5C"));

        //build
        setLocation(600, 150);
        setContentPane(indexPage);
        pack();
        setTitle("login_app");

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    /** 
    *anime only usernamefield and passwordfield label from right to left
    *@param label label we want anime
    */ 
    public void  animeErrorMessageLabel (final JLabel label) {
        final int UPDATE_RATE = 30;
        new Thread() {
           
            public void run()
            {  
                int labelXPosition = 150;
                int labelYPosition = label.getY();
                int labelWidht     = label.getWidth();
                int labelHheight   = label.getHeight();
               
                for (int i = 0; i < 5; i++) {
                    label.setBounds(++labelXPosition, labelYPosition, labelWidht, labelHheight);
                    repaint();
                    try {
                    	Toolkit.getDefaultToolkit().sync();
                        Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
                    } catch (InterruptedException ex) { }
                }

                for (int i = 0; i < 5; i++) {
                    label.setBounds(--labelXPosition, labelYPosition, labelWidht, labelHheight);
                    try {
                    	Toolkit.getDefaultToolkit().sync();
                        Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
                    } catch (InterruptedException ex) { }
                }
               
            }
        }.start();  // Callback run()
        System.out.println("number of Active Thread " + Thread.activeCount()); 
    }

    public void addComponentsToPane() {
        
    }

    public void setLocationAndSizeOfComponents() {
        
    }

    public void init(){
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //if signUpButton is pressed
        if (e.getSource() == signUpButton) {
            char[] passwordArray = passwordField.getPassword();
            String password="";

            if(isPasswordValid && isUsernameValid){
                password = Utilities.arrayToString(passwordArray);
                User user = new User(usernameField.getText(), password);
                dbOperations.CreateUser(user);
                clearAllFields();
                showSucessfullyRegisteredDialogBox();
            }else{

                //i should add usernameEmpty process(like checKforEmpty method)
                checKForEmptyFields();
                if(!isPasswordValid)  animeErrorMessageLabel(passwordErrorValidationMessage);
                if(!isUsernameValid)  animeErrorMessageLabel(usernameErrorValidationMessage);
                
            }
        }

        //if logInButton is pressed
        if (e.getSource() == logInButton) {
            char[] passwordArray = passwordField.getPassword();
            String password="";
            List<User> users = null;
            if(isPasswordValid && isUsernameValid){
                
                password = Utilities.arrayToString(passwordArray);
                User user = new User(usernameField.getText(), password);
                users = dbOperations.readByUsername(user.getUsername());
                System.out.println("\n"+users+"\n");

                if (users.isEmpty() ) {

                    System.out.println("username or password is wrong");
                    ShowUserCantConnectDiaogBox();

                }else {
                    
                    //hashing the password before compare
                    if(users.get(0).getPassword().equals(Utilities.hash(password)) == false ){
                        ShowUserCantConnectDiaogBox();
                        return;
                    } 
                    showSucessfullyConnectDialogBox();
                }
            }else{
                
                checKForEmptyFields();

                if(!isPasswordValid)  animeErrorMessageLabel(passwordErrorValidationMessage);
                if(!isUsernameValid)  animeErrorMessageLabel(usernameErrorValidationMessage);
                
            }
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

            loginOrSignupLabel.setText("SignUp");
            pageName = PageName.SIGNUP;
            indexPage.remove(signUpHyperlinkLabel);
            indexPage.remove(logInButton);

            clearAllFields();
            
            indexPage.add(logInHyperlinkLabel);
            indexPage.add(signUpButton);
            textLabel.setText("Already have an account?");
            indexPage.repaint();

        }else if ( e.getSource() == logInHyperlinkLabel ){

            loginOrSignupLabel.setText("LogIn");
            pageName = PageName.LOGIN;
            indexPage.remove(logInHyperlinkLabel);
            indexPage.remove(signUpButton);

            clearAllFields();

            indexPage.add(signUpHyperlinkLabel);
            indexPage.add(logInButton);
            textLabel.setText("Don't have an account?");
            indexPage.repaint();
        }
    }

    public void clearAllFields() {
        //remove Listener unless DocumentListener method will get fired
        passwordField.getDocument().removeDocumentListener(passwodValidationListener);
        usernameField.getDocument().removeDocumentListener(usernameValidationListener);
        usernameField.setText("");
        passwordField.setText("");
        usernameField.getDocument().addDocumentListener(usernameValidationListener);
        passwordField.getDocument().addDocumentListener(passwodValidationListener);

        usernameField.setBorder(BorderFactory.createLineBorder(Color.decode("#666")));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#666")));
        usernameErrorValidationMessage.setVisible(false);
        passwordErrorValidationMessage.setVisible(false);
        isPasswordValid=false;
        isUsernameValid=false;
    }

    public void checKForEmptyFields() {
        if (usernameField.getText().length()==0) {
            usernameErrorValidationMessage.setVisible(true);
            usernameErrorValidationMessage.setText("!! username is empty");
            isUsernameValid = false;
            usernameField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4500")));
        }
        if (passwordField.getPassword().length == 0) {
            passwordErrorValidationMessage.setVisible(true);
            passwordErrorValidationMessage.setText("!! password is empty");
            isPasswordValid = false;
            passwordField.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4500")));
        }
    }

    public void showSucessfullyConnectDialogBox(){
        JOptionPane.showMessageDialog(indexPage,
        "sucessfully connect");
    }

    public void ShowUserCantConnectDiaogBox() {
        JOptionPane.showMessageDialog(indexPage,
        "username or password is wrong",
        "wrong credentials",
        JOptionPane.ERROR_MESSAGE);
    }

    public void showSucessfullyRegisteredDialogBox() {
        JOptionPane.showMessageDialog(indexPage, 
        "sucessfully Registered"
        );
    }
         

    @Override
    public void mouseEntered(MouseEvent event) {
        
    }

    @Override
    public void mouseExited(MouseEvent event) {
       
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }


    
    public PageName getPageName() {
        return this.pageName;
    }

    public JTextField getUsernameField() {
        return this.usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public void setIsUsernameValid(boolean isValid) {
        this.isUsernameValid=isValid;
    }
    
    public boolean isIsUsernameValid() {
        return this.isUsernameValid;
    }

    public boolean getIsUsernameValid() {
        return this.isUsernameValid;
    }

    public boolean isIsPasswordValid() {
        return this.isPasswordValid;
    }

    public boolean getIsPasswordValid() {
        return this.isPasswordValid;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

   

    public JLabel getUsernameErrorValidationMessage() {
        return this.usernameErrorValidationMessage;
    }
}

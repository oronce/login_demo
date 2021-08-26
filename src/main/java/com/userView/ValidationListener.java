package com.userView;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ValidationListener   {

    private AppView appView;
    private DocumentListener usernameValidationListener ;

    ValidationListener(){
        usernameValidationListener = new DocumentListener(){

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub
                
            }
            
        
        };
    }

    
    
}

package com.userView;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import org.hibernate.userModel.*;

public class MyFocusListener implements FocusListener {

    AppView appView;

    MyFocusListener(AppView appView){
        this.appView = appView;
    }

    @Override
    public void focusGained(FocusEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void focusLost(FocusEvent arg0) {
        if(appView.getPageName() == PageName.LOGIN) return;
        if (appView.getIsUsernameValid()) {

            Thread checkUsernameExist = new Thread() {
                public void run()
                {
                    if( dbOperations.readByUsername(appView.getUsernameField().getText()).isEmpty() == false){
                        appView.setIsUsernameValid(false) ;
                        appView.getUsernameErrorValidationMessage().setVisible(true);
                        appView.getUsernameErrorValidationMessage().setText("!! username is already use ");
                    }
                }
            };
            checkUsernameExist.start();  // Callback run()     
        }
    }
    
}

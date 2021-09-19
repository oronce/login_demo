package com.userView;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppViewTest {

    static AppView appview = null;

    @BeforeClass
    public static void lunchGUi() {
        System.out.println("whta up");
        new AppView().setDefaultCloseOperation(3);
    }

    @Test
    public void name() {
        
        assertTrue(true);
    }

    @AfterClass
    public static void closeGui() {
        
    }
}

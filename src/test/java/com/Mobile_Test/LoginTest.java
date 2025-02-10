package com.Mobile_Test;

import com.Mobile_Utils.BaseClassMobile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseClassMobile {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void login() {
        wait(5000);
        startUp.setupCarousel();
        waitForVisibilityOfTheElement(login.getEmail());
        login.getEmail().click();
        actions.sendKeys("thangavel+01@tuna.com").build().perform();
        wait(2000);
        hideKeyBoard();
        tapEle(login.getSubmitButton());
        wait(10000);
    }
}


       /*
        login.getEmail().click();
        //
        hideKeyBoard();
        tapEle(login.getSubmitButton());
        wait(15000);*/



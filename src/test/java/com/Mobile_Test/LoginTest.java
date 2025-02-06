package com.Mobile_Test;

import com.Mobile_Utils.BaseClassMobile;
import org.testng.annotations.Test;

public class LoginTest extends BaseClassMobile {
    @Test
    public void login() {

        waitForVisibilityOfTheElement(login.getEmail());
        login.getEmail().click();
        actions.sendKeys("thangavel@yopmail.com").build().perform();
        hideKeyBoard();
        tapEle(login.getSubmitButton());
        wait(15000);
    }
}

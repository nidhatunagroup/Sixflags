package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class SignUpTest extends BaseClassWeb {
    @Test
    public void testNewUserRegistration() {
        authWeb.authLogin();
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        signup.new_SignUp(getProp("Email"), getProp("MobileNumber"), getProp("Password"),
                getProp("RetypePassword"));
        waitFor(15000);

    }

    @Test
    public void testInvalidUserRegistration() {
        authWeb.authLogin();
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        signup.new_SignUp("null", " ", " ", " ");
        waitFor(15000);
    }

}


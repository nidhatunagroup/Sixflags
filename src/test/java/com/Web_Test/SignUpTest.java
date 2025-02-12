package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.annotations.Test;

public class SignUpTest extends BaseClassWeb {
    @Test
    public void testNewUserRegistration() {
        authWeb.authLogin();
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        authWeb.getSelectParkDarianLake().click();
        signUp.new_SignUp(getProp("FirstName"), getProp("LastName"), getProp("Email"),
                getProp("Dob"), getProp("MobileNumber"), getProp("Password"),
                getProp("RetypePassword"));
//        authWeb.getBackToHome().click();

        waitFor(15000);

    }


}


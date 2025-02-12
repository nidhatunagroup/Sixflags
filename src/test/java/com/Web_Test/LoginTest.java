
package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.annotations.Test;

public class LoginTest extends BaseClassWeb {
    @Test
    public void testLoginValidUser() {
        authWeb.authLogin();
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        authWeb.getSelectParkDarianLake().click();
        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
        authWeb.getBackToHome().click();
        waitFor(15000);

    }

    @Test
    public void testLoginInvalid() {
        softAssert.assertEquals(driver.get().getTitle(), getProp("Title"), "Title mismatch");
    }



}


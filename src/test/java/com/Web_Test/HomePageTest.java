package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class HomePageTest extends BaseClassWeb {
//    @Test
//    public void test_homePage_planToVisit() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
////        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
//        waitFor(5000);
////        authWeb.getBackToHome().click();
////        waitFor(15000);
//        homepage.planYourVistPage();
//        waitFor(15000);
//    }

    @Test(priority = 1)
    public void test_goTo_appStore() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        waitFor(5000);
        homepage.getAppStore_Page();
    }

    @Test(priority = 12)
    public void test_goTo_playStore() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        waitFor(5000);
        homepage.getPlayStore_Page();
    }
}
package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageFooterTest extends BaseClassWeb {

    @Test(priority = 1)
    public void testGoToAppStore() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
        waitFor(3000);
        footer.getAppStore_Page();
        waitFor(10000);
    }

    @Test(priority = 2)
    public void testGoToPlayStore() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
        waitFor(2000);
        footer.getPlayStore_Page();
        waitFor(5000);
    }

//    @Test(priority = 3)
//    public void testFAQLink() {
////        authWeb.authLogin();
////        waitFor(5000);
////        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
////        authWeb.selectPark();
////        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
//        waitFor(2000);
//        footer.faq_link();
//        waitFor(5000);
//    }

    @Test(priority = 3)
    public void testSocialMediaLink() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
        waitFor(2000);
        footer.socialMediaLink();
        waitFor(5000);
    }

//    @Test(priority = 14)
//    public void testSubscribeButton() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
//        waitFor(5000);
//        footer.click_subscribeButton();
//        waitFor(5000);
//    }

    @Test(priority = 4)
    public void testLostandFound() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
        waitFor(3000);
        footer.click_lostAndFound();
        waitFor(5000);
    }

}

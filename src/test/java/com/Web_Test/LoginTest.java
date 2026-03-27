//
//package com.Web_Test;
//
//import com.Web_Utils.BaseClassWeb;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class LoginTest extends BaseClassWeb {
//    @Test
//    public void testLoginValidUser() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
////        authWeb.getBackToHome().click();
//        waitFor(15000);
//
//    }
//
//    @Test
//    public void testForgotPassword(){
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.validate_forgotPassword(getProp("LoginEmail"));
//    }
//
//    @Test
//    public void testAccountInfo() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
//        waitFor(15000);
//        login.accountInfoCheck();
//    }
//
//    @Test
//    public void testEditAccountInfo() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
//        waitFor(10000);
//        login.editAccountInfo();
//    }
//
//    @Test
//    public void testLoginInvalid() {
//        softAssert.assertEquals(driver.get().getTitle(), getProp("Title"), "Title mismatch");
//    }
//
//}
//

package com.Web_Test;

import com.Web_Pages.AuthWeb;
import com.Web_Utils.BaseClassWeb;
import org.apache.poi.ss.usermodel.Header;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageHeaderTest extends BaseClassWeb {

    @Test(priority = 15)
    public void testLostAndFound_InHeader() {
        AuthWeb.authLogin();
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        waitFor(5000);
        header.click_lostAndFound_InHeader();
        waitFor(3000);
    }

    @Test(priority = 16)
    public void testAccessebility_Check() {
//        authWeb.authLogin();
//        waitFor(5000);
//        authWeb.selectPark();
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        waitFor(5000);
        waitFor(5000);
        header.click_accessebility();
        waitFor(3000);
    }

}
package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.annotations.Test;

public class SearchandPromoTest extends BaseClassWeb {

    @Test(priority = 1)
    public void test_search_an_element() {
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        waitFor(2000);
        search.serach_an_element();
        waitFor(3000);
    }

    @Test(priority = 2)
    public void test_cancel_search() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(3000);
        search.cancel_search();
        waitFor(3000);
    }

    @Test(priority = 3)
    public void test_promoCode() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//     authWeb.selectPark();
        waitFor(3000);
        search.enter_promoCode();
        waitFor(3000);
    }

    @Test(priority = 4)
    public void test_BuyTicket() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
////        login.userLogin(getProp("LoginEmail"), getProp("LoginPassword"));
        waitFor(3000);
        search.click_buyTicket_Button();
        waitFor(5000);
    }

    @Test(priority = 5)
    public void test_Go_button() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(3000);
        search.click_Go_Button();
        waitFor(5000);
    }
}

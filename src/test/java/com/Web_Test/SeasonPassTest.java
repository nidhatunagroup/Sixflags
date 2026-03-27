package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.apache.poi.ss.usermodel.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeasonPassTest extends BaseClassWeb {

    @Test(priority = 1)
    public void test_Click_RandE() {
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        waitFor(5000);
        seasonPass.click_ridesAndExperience();
        waitFor(5000);
    }

    @Test(priority = 2)
    public void test_Click_ParkInfo_inHeader(){
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        waitFor(5000);
        seasonPass.click_park_info();
        waitFor(5000);
    }

    @Test(priority = 3)
    public void testPlaceToStay() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(3000);
        seasonPass.click_placeToStay();
        waitFor(5000);
//        tearDown();
    }

    @Test(priority = 4)
    public void testSeasonPass() {
//        authWeb.authLogin();
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        waitFor(5000);
        seasonPass.click_SeasonPass();
        waitFor(5000);
    }

    @Test(priority = 5)
    public void test_dining_plans() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        waitFor(2000);
        seasonPass.click_dining_plans();
        waitFor(5000);
    }

//    @Test(priority = 6)
//    public void test_summerPass() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
//        waitFor(2000);
//        seasonPass.compare_SeasonPass_summerPass();
//        waitFor(5000);
//    }


}
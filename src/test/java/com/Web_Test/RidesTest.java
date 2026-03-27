package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.annotations.Test;

public class RidesTest extends BaseClassWeb {

    @Test(priority = 1)
    public void verify_ride_section() {
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        waitFor(2000);
        ridesPage.Verify_RidePage_from_HomeTab();
        waitFor(3000);
    }

    @Test(priority = 2)
    public void verify_restaurant_section() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(2000);
        ridesPage.Verify_restaurant_from_HomeTab();
        waitFor(3000);
    }

    @Test(priority = 3)
    public void Verify_nextButton_logoSection() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(2000);
        ridesPage.Verify_logo_by_nextButton();
        waitFor(3000);
    }

    @Test(priority = 4)
    public void Verify_Events_from_HomeTab() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(2000);
        ridesPage.Verify_Events_from_HomeTab();
        waitFor(3000);
    }
    @Test(priority = 5)
    public void Verify_FeatureFilter_inRestaurant() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(2000);
        ridesPage.Verify_FeatureFilter_inRestaurant();
        waitFor(3000);
    }

    @Test(priority = 6)
    public void Verify_SeatingType_Filter_inRestaurant() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(2000);
        ridesPage.Verify_SeatingType_inRestaurant();
        waitFor(3000);
    }

    @Test(priority = 7)
    public void Verify_DiningPass_Filter_inRestaurant() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
//        authWeb.selectPark();
        waitFor(2000);
        ridesPage.Verify_diningPass_inRestaurant();
        waitFor(3000);
    }

}

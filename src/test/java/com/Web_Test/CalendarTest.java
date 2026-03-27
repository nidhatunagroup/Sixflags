package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.apache.poi.ss.usermodel.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarTest extends BaseClassWeb {

    @Test(priority = 1)
    public void test_Calendar_verification() {
        waitFor(4000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        authWeb.selectPark();
        waitFor(3000);
        calendar.datePicker();
        waitFor(2000);
    }
}
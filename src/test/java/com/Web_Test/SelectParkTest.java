package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectParkTest extends BaseClassWeb {
    @Test
    public void selectPark() {
        authWeb.authLogin();
        Assert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Error - Title not as expected");
        authWeb.selectPark();
        Assert.assertEquals(driver.get().getTitle(), getProp("ParkHomeTitle"), "Error - Title not as expected");
           }

}

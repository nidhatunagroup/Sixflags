package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.annotations.Test;

public class SelectPropertyTest extends BaseClassWeb {

    @Test(priority = 1)
    public void verify_type_of_property() {
        waitFor(5000);
        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        property.select_themePark_from_type();
        waitFor(3000);
    }

    @Test(priority = 2)
    public void verify_byLocation_of_property() {
//        waitFor(5000);
//        softAssert.assertEquals(driver.get().getTitle(), getProp("SelectParkTitle"), "Title mismatch");
        property.select_themePark_by_location();
        waitFor(3000);
    }
}

package com.Web_Test;

import com.Web_Utils.BaseClassWeb;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchTabsTest  extends BaseClassWeb {
    @Test
    public void switchBetweenTabs(){
        waitFor(5000);
        switchTabs.rides();
        Assert.assertEquals(driver.get().getTitle(), getProp("RidesTitle"), "Error - Title not as expected");
        switchTabs.dining();
        Assert.assertEquals(driver.get().getTitle(), getProp("RestaurantsTitle"), "Error - Title not as expected");
        switchTabs.cabanas();
        Assert.assertEquals(driver.get().getTitle(), getProp("CabanasTitle"), "Error - Title not as expected");
        switchTabs.ticketAndPasses();
        Assert.assertEquals(driver.get().getTitle(), getProp("TicketsTitle"), "Error - Title not as expected");
        switchTabs.home();
        Assert.assertEquals(driver.get().getTitle(), getProp("ParkHomeTitle"), "Error - Title not as expected");
    }
}

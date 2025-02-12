
package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class SwitchTabs extends BaseClassWeb {
    @FindBy(xpath = "//a[@aria-label='Go to Six Flags Magic Mountain Home']")
    private WebElement backToHome;

    @FindBy(xpath = "//span[normalize-space(text())='Tickets & Passes']")
    private WebElement ticketAndPasses;

    @FindBy(xpath = "//span[normalize-space(text())='Rides']")
    private WebElement rides;

    @FindBy(xpath = "//a[normalize-space(text())='See Our Rides']")
    private WebElement allRides;

    @FindBy(xpath = "//span[normalize-space(text())='Dining']")
    private WebElement dining;

    @FindBy(xpath = "//a[normalize-space(text())='See Dining Options']")
    private WebElement allDining;

    @FindBy(xpath = "//span[normalize-space(text())='Cabanas']")
    private WebElement cabanas;

    @FindBy(xpath = "//a[normalize-space(text())='See Our Cabanas']")
    private WebElement allCabanas;

    @FindBy(xpath = "//span[normalize-space(text())='Shows']")
    private WebElement shows;

    @FindBy(xpath = "//span[normalize-space(text())='Shop']")
    private WebElement shop;

    public void ticketAndPasses() {
        getTicketAndPasses().click();
        waitFor(5000);
    }

    public void rides() {
        getRides().click();
        waitFor(5000);
    }

    public void dining() {
        getDining().click();
        waitFor(5000);
    }

    public void cabanas() {
        getCabanas().click();
        waitFor(5000);
    }

    public void home() {
        getBackToHome().click();
        waitFor(5000);
    }

    public SwitchTabs(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

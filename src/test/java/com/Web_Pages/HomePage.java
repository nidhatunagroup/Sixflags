package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


@Getter
@Setter
public class HomePage extends BaseClassWeb {

    @FindBy(xpath = "(//span[contains(text(),'To Plan Your Visit')])")
    private WebElement planToVisit_Title;

    @FindBy(xpath = "(//h2[contains(text(),'Everything You Need')])")
    private WebElement scrollPoint;

    @FindBy(xpath = "(//a[@aria-label='Visit Directions to the Park']//span)")
    private WebElement learnMore;

    @FindBy(xpath = "(//h4[contains(text(), 'DIRECTIONS')])")
    private WebElement directionsText_inNextpage;

    @FindBy(xpath = "(//a[@aria-label='Go to Six Flags Darien Lake Home'])")
    private WebElement goBackToHome;

    @FindBy(xpath = "//a[@aria-label='Download on the App Store']")
//    @FindBy(xpath = "//a[@href='https://apps.apple.com/us/app/six-flags/id988953433']")
    private WebElement downloadAppStore;

    @FindBy(xpath = "//a[@aria-label='Download on the Play Store']")
    private WebElement downloadPlayStore;

    @FindBy(xpath = "(//h2[contains(text(),'Get The App')])")
    private WebElement getTheAppText;

    @FindBy(xpath = "(//a[contains(text(),'Get Help')])")
    private WebElement getHelp;



    public void planYourVistPage() {
//        clickElement(getGoBackToHome());
        webScroll_and_click(getPlanToVisit_Title());
        softAssert.assertEquals(getPlanToVisit_Title(), getProp("To Plan Your Visit"), "Title mismatch");
        clickElement(getLearnMore());
        softAssert.assertEquals(getDirectionsText_inNextpage(), getProp("DIRECTIONS"), "Title mismatch");
    }

    public void getAppStore_Page(){
        for (int i = 0; i < 9; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            waitFor(2000);
        }
//        clickElement(getDownloadAppStore());
//        getDownloadAppStore().click();
        driver.get().findElement(By.xpath("//a[@href='https://apps.apple.com/us/app/six-flags/id988953433']")).click();
        waitFor(2000);
    }

    public void getPlayStore_Page(){
        for (int i = 0; i < 10; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            waitFor(2000);
        }
//        clickElement(getDownloadAppStore());
//        getDownloadAppStore().click();
        driver.get().findElement(By.xpath("//a[@aria-label='Download on the Play Store']")).click();
        waitFor(2000);
    }

    public HomePage(WebDriver webDriver) {
        super();
        actions = new Actions(driver.get());
    }
}
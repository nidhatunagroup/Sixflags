package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


@Getter
@Setter
public class PageFooter extends BaseClassWeb {

    @FindBy(xpath = "//a[@aria-label='Download on the App Store']")
    private WebElement downloadAppStore;

    @FindBy(xpath = "//a[@aria-label='Download on the Play Store']")
    private WebElement downloadPlayStore;

    @FindBy(xpath = "//h2[normalize-space()='Helpful Links']")
    private WebElement helpFullLink_heading;

    @FindBy(xpath = "//a[normalize-space()='Frequently Asked Questions']")
    private WebElement faq_link;

    @FindBy(xpath = "//h2[normalize-space()='Online Purchases']")
    private WebElement onlinePurchaseTitle;

    @FindBy(xpath = "//a[@aria-label='facebook']")
    private WebElement facebookLink;

    @FindBy(xpath = "//h2[contains(text(),'Get The App')]")
    private WebElement getTheApp;

    @FindBy(xpath = "//button[contains(text(),'Subscribe')]")
    private WebElement subscribeButton;

    @FindBy(xpath = "//a[contains(text(),'Lost and Found')]")
    private WebElement lostAndFound;

    @FindBy(xpath = "//ul[@class='flex items-center']//button[contains(text(),'Help & Information')]")
    private WebElement help_and_information_section;

    public void getAppStore_Page() {
        System.out.println("Scrolled to App Store download link...");
        // Store current window handle
        String parentWindow = driver.get().getWindowHandle();

        webScroll_and_click(getDownloadAppStore());
        waitFor(3000);
        System.out.println("Clicked App Store download link...");

        //Switch to new window
        for (String windowHandle : driver.get().getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.get().switchTo().window(windowHandle);
                System.out.println("Switched to App Store window: " + driver.get().getTitle());
                break;
            }
        }

        waitFor(2000);
        softAssert.assertTrue(driver.get().getCurrentUrl().contains("apple.com"),
                "App Store page did not open correctly");

        //Close child window and switch back
        driver.get().close();
        driver.get().switchTo().window(parentWindow);
    }


    public void getPlayStore_Page(){
        System.out.println("Scrolled to App Store download link...");
        // Store current window handle
        String parentWindow = driver.get().getWindowHandle();

        webScroll_and_click(getDownloadPlayStore());
        waitFor(3000);
        System.out.println("Clicked Play Store download link...");

        //Switch to new window
        for (String windowHandle : driver.get().getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.get().switchTo().window(windowHandle);
                System.out.println("Switched to Play Store window: " + driver.get().getTitle());
                break;
            }
        }

        waitFor(2000);
        softAssert.assertTrue(driver.get().getCurrentUrl().contains("play.google.com"),
                "App Store page did not open correctly");

        //Close child window and switch back
        driver.get().close();
        driver.get().switchTo().window(parentWindow);
    }

//    public void faq_link(){
//        System.out.println("Scrolled to FAQ link...");
//        webScroll_and_click(getFaq_link());
//        waitFor(5000);
//        clickElement(getFaq_link());
//        System.out.println("Clicked FAQ link...");
//        waitFor(5000);
//        try{
//            if (getOnlinePurchaseTitle().isDisplayed()) {
//                String actualText = getOnlinePurchaseTitle().getText();
//                String expectedText = "Online Purchases";
//                Assert.assertEquals(actualText, expectedText, "String mismatch");
//                System.out.println("Online purchase title is verified in FAQ");
//            }
//        }catch (NoSuchElementException e) {
//            System.out.println("Online purchase title is not verified in FAQ, verification failed");
//        }
//        String actualText = getOnlinePurchaseTitle().getText();
//        String expectedText = "Online Purchases";
//        Assert.assertEquals(actualText, expectedText, "String mismatch");
//    }

    public void socialMediaLink(){
        String parentWindow = driver.get().getWindowHandle();

        webScroll_and_click(getFacebookLink());
        waitFor(5000);
        System.out.println("Clicked social media link...");

        for (String windowHandle : driver.get().getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.get().switchTo().window(windowHandle);
                System.out.println("Switched to Play Store window: " + driver.get().getTitle());
                break;
            }
        }

        waitFor(2000);
        softAssert.assertTrue(driver.get().getCurrentUrl().contains("facebook.com"),
                "App Store page did not open correctly");

        //Close child window and switch back
        driver.get().close();
        driver.get().switchTo().window(parentWindow);

    }

    public void click_subscribeButton(){
        System.out.println("Scrolled to subscribe button...");
        webScroll_and_click(getSubscribeButton());
        waitFor(3000);
        clickElement(getSubscribeButton());
        System.out.println("Clicked subscribe button...");
    }

    public void click_lostAndFound(){
//        System.out.println("Scrolled to Park info...");
//        webScroll_and_click(getLostAndFound());
        clickElement(getHelp_and_information_section());
        waitFor(3000);
        clickElement(getLostAndFound());
        System.out.println("Clicked Lost and Found...");
    }

    public PageFooter(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

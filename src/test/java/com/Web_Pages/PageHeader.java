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
public class PageHeader extends BaseClassWeb {

    @FindBy(xpath = "//a[contains(text(),'Lost & Found')]")
    private WebElement lostAndFound;

    @FindBy(xpath = "//button[contains(text(),'Park Info')]")
    private WebElement parkInfoTab;

    @FindBy(xpath = "//nav[@aria-label='Site Navigation']//li[1]//span")
    private WebElement helpAndInfo_collapse;

    @FindBy(xpath = "//ul[@aria-label='Helpful Information']//a[contains(text(),'Accessibility')]")
    private WebElement accessebility_Button;

    @FindBy(xpath = "//section[2]//h2[contains(text(),'Accessibility')]")
    private WebElement accessibility_Title;

//    @FindBy(xpath = "//h1[contains(text(),'Lost & Found')]")
    @FindBy(xpath = "//h1[contains(text(),'Lost and Found')]")
    private WebElement lost_and_found_title;

    @FindBy(xpath = "//a[@aria-label='Go to Cedar Point Home']")
    private WebElement homePageLogo;


    public void click_lostAndFound_InHeader(){
        clickElement(getParkInfoTab());
        waitFor(3000);
        clickElement(getLostAndFound());
        waitFor(2000);
        System.out.println("Clicked Lost and Found...");
//        clickElement(getParkInfoTab());
        waitFor(3000);
        softAssert.assertTrue(getLost_and_found_title().isDisplayed());
//        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void click_accessebility(){
        clickElement(getParkInfoTab());
        waitFor(3000);
        System.out.println("Help and Information collapse button clicked");
        clickElement(getAccessebility_Button());
        softAssert.assertEquals(getAccessibility_Title(), getProp("Accessibility"), "Title mismatch");
    }


    public PageHeader(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

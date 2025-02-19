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

    public void planYourVistPage() {
//        clickElement(getGoBackToHome());
        webScroll_and_click(getPlanToVisit_Title());
        softAssert.assertEquals(getPlanToVisit_Title(), getProp("To Plan Your Visit"), "Title mismatch");
        clickElement(getLearnMore());
        softAssert.assertEquals(getDirectionsText_inNextpage(), getProp("DIRECTIONS"), "Title mismatch");
    }


    public HomePage(WebDriver webDriver) {
        super();
    }
}
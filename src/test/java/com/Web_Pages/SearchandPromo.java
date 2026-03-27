package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
@Setter

public class SearchandPromo extends BaseClassWeb {

    @FindBy(xpath = "//button[@aria-label='Open Search']//span[@class='ui-button-link-underline-animation']")
    private WebElement search_with_underlineAnimation;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement input_text_field;

    @FindBy(xpath = "//div[@id='input-search-container']//button[@aria-label='Close Search']")
    private WebElement close_search_button;

    @FindBy(xpath = "//h1[contains(text(),'Search Results')]")
    private WebElement search_result_title;

    @FindBy(xpath = "//span[contains(text(),'Promo Code')]")
    private WebElement promoCode_button;

    @FindBy(xpath = "//input[@placeholder='Enter Promo Code']")
    private WebElement promo_code_title_nextBox;

    @FindBy(xpath = "//button[contains(text(),'Go')]")
    private WebElement click_go;

    @FindBy(xpath ="//span[contains(text(),'No Packages Found')]")
    private WebElement promoCodeErrorMessage;

    @FindBy(xpath = "//h1[contains(text(),'Enter Promotional Code')]")
    private WebElement promoCodeSuccessMessage;

    @FindBy(xpath = "//div[@id='overlayCloseContainer']//div[@aria-label='Close Store']")
    private WebElement closeOverlayContainer_button;

//    @FindBy(xpath = "//a[@id='tickets-passes-button']")
    @FindBy(xpath = "//a[@aria-label='Buy Tickets']")
    private WebElement buyTicketButton;

    @FindBy(xpath = "//button[contains(text(),'Daily Tickets')]")
    private WebElement dailyTickets_button_and_title;

    @FindBy(xpath = "//a[@aria-label='Go to Cedar Point Home']")
    private WebElement homePageLogo;

    @FindBy(xpath = "//ul[@class='swiper-wrapper']//li[1]//a")
    private WebElement go_button_ticketPage;

    @FindBy(xpath = "//div[@role='tablist']//div")
    private WebElement tablist;

    @FindBy(xpath = "//h1[contains(text(),'Upgrade Your Fun')]")
    private WebElement last_flexBlock;


    public void serach_an_element(){
        clickElement(getSearch_with_underlineAnimation());
        waitFor(3000);
        getInput_text_field().sendKeys("Rides");
        getInput_text_field().sendKeys(Keys.ENTER);
        waitFor(3000);
        System.out.println("waiting for results...");
        softAssert.assertTrue(getSearch_result_title().isDisplayed());
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void cancel_search(){
        clickElement(getSearch_with_underlineAnimation());
        waitFor(3000);
        getInput_text_field().sendKeys("Rides");
        waitFor(3000);
        clickElement(getClose_search_button());
        softAssert.assertTrue(getSearch_with_underlineAnimation().isDisplayed());
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void enter_promoCode() {
        clickElement(getPromoCode_button());
        waitFor(2000);

        try {
            if (!getPromo_code_title_nextBox().isDisplayed()) {
                System.out.println("No promo code field available.");
                softAssert.fail("Promo code field is not visible");
                return;
            }

            getPromo_code_title_nextBox().sendKeys("ZBNHT67997");
            clickElement(getClick_go());
            waitFor(8000);

            if (getPromoCodeSuccessMessage().isDisplayed()) {
                System.out.println("Promo code applied successfully.");
            } else if (getPromoCodeErrorMessage().isDisplayed()) {
                System.out.println("Invalid promo code.");
                softAssert.fail("Invalid promo code entered.");
            } else {
                System.out.println("No validation message found after applying promo.");
                softAssert.fail("Promo code status could not be determined.");
            }

        } catch (NoSuchElementException e) {
            System.out.println("Promo code field not found.");
            softAssert.fail(STR."Promo code field not found: \{e.getMessage()}");
        } finally {
            clickElement(getCloseOverlayContainer_button());
            clickElement(getHomePageLogo());
            waitFor(3000);
        }
    }

    public void click_buyTicket_Button() {
//        moveToElement(getSearch_with_underlineAnimation());
        clickElement(getBuyTicketButton());
        waitFor(2000);
        System.out.println("Clicked Buy Tickets...");
        softAssert.assertTrue(getDailyTickets_button_and_title().isDisplayed());
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void click_Go_Button() {
//        moveToElement(getSearch_with_underlineAnimation());
        clickElement(getBuyTicketButton());
        waitFor(2000);
        System.out.println("Clicked Buy Tickets...");
        softAssert.assertTrue(getDailyTickets_button_and_title().isDisplayed());
        waitFor(2000);
        moveToElement(getLast_flexBlock());
        waitFor(2000);
        clickElement(getGo_button_ticketPage());
        waitFor(4000);
        softAssert.assertTrue(getTablist().isDisplayed());
        clickElement(getHomePageLogo());
        waitFor(2000);
    }

    public SearchandPromo(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

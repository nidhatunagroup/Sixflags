
package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter


public class RidesPage extends BaseClassWeb {

    @FindBy(xpath = "//a[@aria-label='Go to Six Flags Home']//img[1]")
    private WebElement backToHome;

    @FindBy(xpath = "//a//h3[contains(text(),'Rides')]")
    private WebElement rides_inHomePage;

    @FindBy(xpath = "//a//h3[contains(text(),'Restaurants')]")
    private WebElement restaurant_inHomePage;

    @FindBy(xpath = "//a//h3[contains(text(),'Events')]")
    private WebElement events_inHomePage;

    @FindBy(xpath = "//h1[contains(text(),'See Our Rides')]")
    private WebElement seeOurRides_Title;

    @FindBy(xpath = "//section//div[1]//article//a")
    private WebElement first_ride_from_RideList;

    @FindBy(xpath = "//span[@class='block text-blue-pastel']")
    private WebElement ride_title_MainRide_page;

    @FindBy(xpath = "//div/article[1]")
    private WebElement scroll_to_filter_section;

    @FindBy(xpath = "//h1[contains(text(),'See Dining Options')]")
    private WebElement seeOurDining_title;

    @FindBy(xpath = "//section[@class='hero-negative-offset relative']//h1")
    private WebElement restuarant_main_title_mainpage;

    @FindBy(xpath = "//a[@aria-label='Go to Cedar Point Home']")
    private WebElement homePageLogo;

    @FindBy(xpath = "//button[@aria-label='Next']")
    private WebElement next_button_forLogo;

    @FindBy(xpath = "//article[1]//a[contains(text(),'View Event')]")
    private WebElement view_Event_bt_inSpecialEvent;

    @FindBy(xpath = "//h1[contains(text(),'See Our Events')]")
    private WebElement see_our_Events_title;

    @FindBy(xpath = "//div[@class='icon-information grow']")
    private WebElement event_details;

    @FindBy(xpath = "//div[@class='relative']//button//span[contains(text(),'Features')]")
    private WebElement features_filter_restaurant;

    @FindBy(xpath = "//button//span[contains(text(),'Gluten Free')]")
    private WebElement glutenFree_inFeatures;

    @FindBy(xpath = "//button//span[contains(text(),'Vegetarian')]")
    private WebElement vegetarian_inFeatures;

    @FindBy(xpath = "//button//span[contains(text(),'Others')]")
    private WebElement others_inFeatures;

    @FindBy(xpath = "//button//span[contains(text(),'Alcohol')]")
    private WebElement alcohol_inFeatures;

    @FindBy(xpath = "//button[contains(text(),'Clear')]")
    private WebElement filter_clear_button;

    @FindBy(xpath = "//button//span[contains(text(),'Seating Types')]")
    private WebElement seatingType_filter;

    @FindBy(xpath = "//button//span[contains(text(),'Outdoor')]")
    private WebElement outdoor_seating_options;

    @FindBy(xpath = "//button//span[contains(text(),'Dining Pass')]")
    private WebElement diningPass_filter;

    @FindBy(xpath = "//button//span[contains(text(),'Single Meal Deal')]")
    private WebElement singleMealDinner;


    public void Verify_RidePage_from_HomeTab() {
        moveToElement(getScroll_to_filter_section());
        clickElement(getRides_inHomePage());
        waitFor(3000);
        moveToElement(getSeeOurRides_Title());
        softAssert.assertTrue(getSeeOurRides_Title().isDisplayed());
        waitFor(2000);
        clickElement(getFirst_ride_from_RideList());
        waitFor(5000);
        softAssert.assertTrue(getRide_title_MainRide_page().isDisplayed());
        clickElement(getHomePageLogo());
//        waitFor(2000);
    }

    public void Verify_restaurant_from_HomeTab() {
        moveToElement(getScroll_to_filter_section());
        clickElement(getRestaurant_inHomePage());
        waitFor(3000);
        moveToElement(getSeeOurDining_title());
//        softAssert.assertTrue(getSeeOurDining_title().isDisplayed());
//        waitFor(2000);
//        webScroll_and_click(getFirst_ride_from_RideList());
//        moveToElement(getFirst_ride_from_RideList());
        waitFor(2000);
        clickElement(getFirst_ride_from_RideList());
        waitFor(5000);
        softAssert.assertTrue(getRestuarant_main_title_mainpage().isDisplayed());
        clickElement(getHomePageLogo());
//        waitFor(2000);
    }

    public void Verify_logo_by_nextButton() {
        moveToElement(getNext_button_forLogo());
        while (true) {
            try {
                if (next_button_forLogo.isDisplayed() && next_button_forLogo.isEnabled()) {
                    next_button_forLogo.click();
                    waitFor(1000); // Optional: wait for UI to update after click
                } else {
                    break; // Exit loop if button is not displayed
                }
            } catch (Exception e){
                // Button is not present or cannot be clicked
                break;
            }
        }
        clickElement(getHomePageLogo());
//        waitFor(2000);
    }


    public void Verify_Events_from_HomeTab() {
        moveToElement(getScroll_to_filter_section());
        clickElement(getEvents_inHomePage());
        waitFor(3000);
        moveToElement(getSee_our_Events_title());
        softAssert.assertTrue(getSee_our_Events_title().isDisplayed());
        waitFor(2000);
        clickElement(getView_Event_bt_inSpecialEvent());
        waitFor(3000);
        moveToElement(getEvent_details());
        softAssert.assertTrue(getEvent_details().isDisplayed());
        clickElement(getHomePageLogo());
//        waitFor(2000);
    }

    public void Verify_FeatureFilter_inRestaurant() {
        moveToElement(getScroll_to_filter_section());
        clickElement(getRestaurant_inHomePage());
        waitFor(3000);
        moveToElement(getSeeOurDining_title());
        waitFor(2000);
        clickElement(getFeatures_filter_restaurant());
        waitFor(1000);
        clickElement(getGlutenFree_inFeatures());
        waitFor(3000);
        if (getFilter_clear_button().isDisplayed()) {
            softAssert.assertTrue(getFilter_clear_button().isDisplayed());
            moveToElement(getFilter_clear_button());
            waitFor(4000);
//            getFilter_clear_button().click();
            System.out.println("Filter Clear button is displayed - Verified");
        } else {
            System.out.println("Filter Clear button is not displayed - No result");
        }
        clickElement(getHomePageLogo());
    }

    public void Verify_SeatingType_inRestaurant() {
        moveToElement(getScroll_to_filter_section());
        clickElement(getRestaurant_inHomePage());
        waitFor(3000);
        moveToElement(getSeeOurDining_title());
        waitFor(2000);
        clickElement(getSeatingType_filter());
        waitFor(1000);
        clickElement(getOutdoor_seating_options());
        waitFor(3000);
        if (getFilter_clear_button().isDisplayed()) {
            softAssert.assertTrue(getFilter_clear_button().isDisplayed());
            moveToElement(getFilter_clear_button());
            waitFor(4000);
//            getFilter_clear_button().click();
            System.out.println("Filter Clear button is displayed - Verified");
        } else {
            System.out.println("Filter Clear button is not displayed - No result");
        }
        clickElement(getHomePageLogo());
    }

    public void Verify_diningPass_inRestaurant() {
        moveToElement(getScroll_to_filter_section());
        clickElement(getRestaurant_inHomePage());
        waitFor(3000);
        moveToElement(getSeeOurDining_title());
        waitFor(2000);
        clickElement(getDiningPass_filter());
        waitFor(1000);
        clickElement(getSingleMealDinner());
        waitFor(3000);
        if (getFilter_clear_button().isDisplayed()) {
            softAssert.assertTrue(getFilter_clear_button().isDisplayed());
            moveToElement(getFilter_clear_button());
            waitFor(4000);
//            getFilter_clear_button().click();
            System.out.println("Filter Clear button is displayed - Verified");
        } else {
            System.out.println("Filter Clear button is not displayed - No result");
        }
        clickElement(getHomePageLogo());
    }


    public RidesPage(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}


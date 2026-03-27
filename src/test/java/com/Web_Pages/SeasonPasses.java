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
public class SeasonPasses extends BaseClassWeb {

    @FindBy(xpath = "//button[contains(text(),'Tickets & Passes')]")
    private WebElement TicketAndPasses_Title;

    @FindBy(xpath = "//ul[@aria-label='Park Admission']//li//a[contains(text(),'Season Passes')]")
    private WebElement seasonPass_InCollapse;

    @FindBy(xpath = "//h2[normalize-space()='Compare Season Pass Benefits']")
    private WebElement verify_seasonPass_page;

    @FindBy(xpath = "//ul[@aria-label='Park Admission']//li[normalize-space()='Memberships']")
    private WebElement click_on_Membership_Button;

    @FindBy(xpath = "//h3[normalize-space()='Gold Membership']")
    private WebElement gold_membership_text;

    @FindBy(xpath = "//div[@class='break-words']")
    private WebElement amount_Text;

    @FindBy(xpath = "//span//button[@aria-label='Expand Places to Stay Menu']")
    private WebElement placeToStay_Title_Expand;

    @FindBy(xpath = "//span//button[@aria-label='Collapse Places to Stay Menu ']")
    private WebElement placeToStay_Title_Collapse;

    @FindBy(xpath = "//ul[@aria-label='Cedar Point Resorts']//li[2]")
    private WebElement firstOptionInResortList;

    @FindBy(xpath = "//a[contains(text(), 'Book Your Stay')]")
    private WebElement bookYourStay;

    @FindBy(xpath = "//main[@id='maincontent']//section")
    private WebElement click_mainArea;

    @FindBy(xpath = "//button[@aria-label='Expand Rides & Experiences Menu']")
    private WebElement rides_and_experience_Expand_in_header;

    @FindBy(xpath = "//button[@aria-label='Collapse Rides & Experiences Menu ']")
    private WebElement rides_and_experience_Collapse_inHeader;

    @FindBy(xpath = "//ul[@aria-label='Rides & Attractions']//li[2]")
    private WebElement firstOptionInRidesList;

    @FindBy(xpath = "//h1[contains(text(),'See Our Rides')]")
    private WebElement seeOurRides_Title;

    @FindBy(xpath = "//div//div[@id='scroll-section']")
    private WebElement click_outsideFrame;

    @FindBy(xpath = "//button[@aria-label='Expand Park Info Menu']")
    private WebElement park_info_section_InHeader_Expand;

    @FindBy(xpath = "//ul[@aria-label='Planning Tools']//li[2]")
    private WebElement parkinfo_list;

    @FindBy(xpath = "//span[contains(text(),'Park Hours And Calendar')]")
    private WebElement parkHours_and_Calendar_title;

    @FindBy(xpath = "//button[@aria-label='Collapse Park Info Menu ']")
    private WebElement park_info_section_InHeader_Collapse;

    @FindBy(xpath = "//ul[@aria-label='Upgrades & Add-Ons']//li[2]")
    private WebElement dining_plans_InTicketAndPasses;

    @FindBy(xpath = "//h2[contains(text(),'Upgrades & Add-Ons')]")
    private WebElement upgrade_addOns_title;

    @FindBy(xpath = "//a[@aria-label='Go to Cedar Point Home']")
    private WebElement homePageLogo;

//    @FindBy(xpath = "//div[contains(text(),'Summer Pass')]//following::button[contains(text(),'Buy Now')][1]")
    @FindBy(xpath = "//tr//td[1]//button[contains(text(),'Buy Now')][1]")
    private WebElement buyNow_button_for_summerPass;

    @FindBy(xpath = "//tr//td[2]//button[contains(text(),'Buy Now')][1]")
    private WebElement buyNow_button_for_GoldPass;

    @FindBy(xpath = "//tr//td[3]//button[contains(text(),'Buy Now')][1]")
    private WebElement buyNow_button_for_PrestigePass;

    @FindBy(id = "desktop-navigation")
    private WebElement iFrame_navigation;

    @FindBy(xpath = "//div[@aria-label='Close Store']")
    private WebElement close_Iframe;


    public void click_SeasonPass(){
        clickElement(getTicketAndPasses_Title());
        waitFor(2000);
        clickElement(getSeasonPass_InCollapse());
        waitFor(3000);
        System.out.println("Season pass button clicked...");
//        clickElement(getAmount_Text());
        moveToElement(getVerify_seasonPass_page());
        softAssert.assertTrue(getVerify_seasonPass_page().isDisplayed());
        System.out.println("_____Verified_____");
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void click_placeToStay(){
        clickElement(getPlaceToStay_Title_Expand());
        waitFor(2000);
        clickElement(getFirstOptionInResortList());
        waitFor(2000);
        System.out.println("First option in resorts list clicked...");
//        clickElement(getPlaceToStay_Title_Collapse());
        softAssert.assertTrue(getBookYourStay().isDisplayed());
        System.out.println("_____Verified_____");
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void click_ridesAndExperience(){
        clickElement(getRides_and_experience_Expand_in_header());
        waitFor(3000);
        clickElement(getFirstOptionInRidesList());
        waitFor(3000);
        System.out.println("First option in rides and experience list clicked...");
        clickElement(getRides_and_experience_Collapse_inHeader());
        moveToElement(getSeeOurRides_Title());
        softAssert.assertTrue(getSeeOurRides_Title().isDisplayed());
        System.out.println("_____Verified_____");
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void click_park_info() {
        clickElement(getPark_info_section_InHeader_Expand());
        waitFor(5000);
        clickElement(getParkinfo_list());
        waitFor(2000);
        System.out.println("First option in park info list clicked...");
//        clickElement(getPark_info_section_InHeader_Collapse());
        softAssert.assertTrue(getParkHours_and_Calendar_title().isDisplayed());
        System.out.println("_____Verified_____");
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void click_dining_plans() {
        clickElement(getTicketAndPasses_Title());
        waitFor(5000);
        clickElement(getDining_plans_InTicketAndPasses());
        waitFor(2000);
        System.out.println("First option in upgrade and Add-ons list clicked...");
//        clickElement(getTicketAndPasses_Title());
        softAssert.assertTrue(getUpgrade_addOns_title().isDisplayed());
        System.out.println("_____Verified_____");
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public void compare_SeasonPass_summerPass(){
        clickElement(getTicketAndPasses_Title());
        waitFor(2000);
        clickElement(getSeasonPass_InCollapse());
        waitFor(2000);
        System.out.println("Season pass button clicked...");
        clickElement(getTicketAndPasses_Title());
//        moveToElement(getVerify_seasonPass_page());
//        softAssert.assertTrue(getVerify_seasonPass_page().isDisplayed());
        moveToElement(getBuyNow_button_for_summerPass());
        waitFor(3000);
        clickElement(getBuyNow_button_for_summerPass());
        waitFor(10000);
        softAssert.assertTrue(getIFrame_navigation().isDisplayed());
        System.out.println("_____Buy Now button Verified_____");
        clickElement(getClose_Iframe());
        clickElement(getHomePageLogo());
        waitFor(3000);
    }


    public SeasonPasses(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}
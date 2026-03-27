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
public class SelectProperty extends BaseClassWeb {

    @FindBy(xpath = "//button//span[contains(text(),'All Types')]")
    private WebElement allType_filter_Button;

    @FindBy(xpath = "//li//button//span[contains(text(),'Theme Park')]")
    private WebElement select_ThemePark_inList;

    @FindBy(xpath = "//button[contains(text(),'Clear All')]")
    private WebElement clearAll_button;

    @FindBy(xpath = "//button[contains(text(),'Sort By Distance')]")
    private WebElement sortByDistance_button;

    @FindBy(xpath = "//main[@id='maincontent']//div[2]//article[1]")
    private WebElement property_view;

    @FindBy(xpath = "//a[contains(text(),'Select Property')]")
    private WebElement selectParkHome;

    @FindBy(xpath = "//p[contains(text(),'No results found')]")
    private WebElement no_result_found_text;

    @FindBy(xpath = "//li//button//span[contains(text(),'Maryland')]")
    private WebElement select_Maryland_location;

    @FindBy(xpath = "//button//span[contains(text(),'All Locations')]")
    private WebElement all_Location_filter_button;


    public void select_themePark_from_type() {
        waitFor(5000);
//        getAcceptAllCookies().click();
        waitForElement(getSelectParkHome());
        getSelectParkHome().click();
        waitFor(1000);
        clickElement(getAllType_filter_Button());
        waitFor(2000);
        clickElement(getSelect_ThemePark_inList());
        if (getProperty_view().isDisplayed()) {
            softAssert.assertTrue(getProperty_view().isDisplayed());
            System.out.println("Theme Park is displayed - Verified");
        } else {
            softAssert.assertTrue(getNo_result_found_text().isDisplayed());
            System.out.println("No result found - Verified");
        }
        waitFor(2000);
        clickElement(getClearAll_button());
    }

    public void select_themePark_by_location(){
//        waitFor(5000);
////        getAcceptAllCookies().click();
//        waitForElement(getSelectParkHome());
//        getSelectParkHome().click();
        waitFor(1000);
        clickElement(getAll_Location_filter_button());
        waitFor(2000);
        clickElement(getSelect_Maryland_location());
        waitFor(1000);
        if (getProperty_view().isDisplayed()) {
            softAssert.assertTrue(getProperty_view().isDisplayed());
            System.out.println("Theme Park is displayed - Verified");
        } else {
            softAssert.assertTrue(getNo_result_found_text().isDisplayed());
            System.out.println("No result found - Verified");
        }
        waitFor(2000);
        clickElement(getClearAll_button());
    }


    public SelectProperty(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

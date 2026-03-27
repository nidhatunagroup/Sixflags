package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;

@Getter
@Setter
public class AuthWeb extends BaseClassWeb {

    @FindBy(xpath = "//a[contains(text(),'Select Property')]")
    private WebElement selectParkHome;

    @FindBy(xpath = "//input[@id='searchPark']")
    private WebElement searchParkTextBox;

//    @FindBy(xpath = "//a[@aria-label='Go to Six Flags Home']//img[1]")
    @FindBy(xpath = "(//a[@aria-label='Go to Six Flags Magic Mountain Home']//img[1])")
    private WebElement backToHome;

    @FindBy(tagName = "iframe")
    private List<WebElement> frames;

    @FindBy(xpath = "(//a[contains(text(),'Darien Lake')])")
//    @FindBy(xpath = "//a[ends-with(normalize-space(text(), 'Darien Lake'))]")
    private WebElement darienLake;

    @FindBy(xpath = "(//a[contains(text(),'Six Flags Magic Mountain')])")
    private WebElement magicMountain;

    @FindBy(xpath = "//main[@id ='maincontent']/div/button/div/h2/span")
    private WebElement choosePark;

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement acceptAllCookies;

    public static void navigateToURL(String URL) {
        driver.get().get(URL);
    }

    public static void authLogin() {
        navigateToURL(getProp("URL"));
        waitFor(5000);
//        actions.sendKeys(Keys.TAB)
//                .sendKeys(getProp("Email"))
//                .sendKeys(Keys.TAB)
//                .sendKeys(getProp("Password"))
//                .sendKeys(Keys.ENTER).build().perform();
    }

    public void selectPark() {
        waitFor(5000);
//        getAcceptAllCookies().click();
        waitForElement(getSelectParkHome());
        getSelectParkHome().click();
        waitFor(2000);
        getSearchParkTextBox().sendKeys(getProp("ParkName"));
        waitFor(2000);
        webScroll_and_click(getChoosePark());
//        getChoosePark().click();
//        scroll_till(getChoosePark());
    }

//    public void selectPark_magicMountain() {
//        waitFor(5000);
//        getAcceptAllCookies().click();
//        waitForElement(getSelectParkHome());
//        getSelectParkHome().click();
//        getSearchParkTextBox().sendKeys(getProp("ParkName"));
//        webScroll_and_click(getMagicMountain());
//        getMagicMountain().click(); }


    public AuthWeb(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
        actions = new Actions(driver.get());
    }

}
/*
@FindBy(xpath = "//input[@type='checkbox']")
private WebElement showPassword;
public void clickShowPassword() {
    getShowPassword().click();
     @FindBy(xpath = "//input[@placeholder='name@host.com']")
    private WebElement email;

    @FindBy(id = "//*[@id=signInFormPassword]")
    private WebElement password;

    @FindBy(xpath = "(//input[@name='signInSubmitButton'])[1]")
    private WebElement signIn;
 public void enterUsername(String username) {
        waitForElement(getEmail());
        ((JavascriptExecutor) driver.get()).executeScript("arguments[0].click();", getEmail());
        getEmail().sendKeys(username);
    }

    public void enterPassword(String password) {
        ((JavascriptExecutor) driver.get()).executeScript("arguments[0].click();", getPassword());
        getPassword().sendKeys(password);
    }
       public void clickOnSignIn() {
        clickElement(getSignIn());
    }
}*/

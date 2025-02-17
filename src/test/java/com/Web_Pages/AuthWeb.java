package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;

@Getter
@Setter
public class AuthWeb extends BaseClassWeb {

    @FindBy(linkText="Select Park")
    private WebElement selectParkHome;

    @FindBy(id = "searchPark")
    private WebElement searchParkTextBox;

    @FindBy(xpath = "//a[@aria-label='Go to Six Flags Home']//img[1]")
    private WebElement backToHome;

    @FindBy(tagName = "iframe")
    private List<WebElement> frames;

    @FindBy(xpath="(//a[@aria-hidden='true'])[7]")
    private WebElement darienLake;

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement acceptAllCookies;

    public void navigateToURL(String URL) {
        driver.get().get(URL);
    }

    public void authLogin() {
        navigateToURL(getProp("URL"));
        waitFor(5000);
        actions.sendKeys(Keys.TAB)
                .sendKeys(getProp("Email"))
                .sendKeys(Keys.TAB)
                .sendKeys(getProp("Password"))
                .sendKeys(Keys.ENTER).build().perform();
    }

    public void selectPark() {
        waitFor(5000);
        getAcceptAllCookies().click();
        waitForElement(getSelectParkHome());
        getSelectParkHome().click();
        getSearchParkTextBox().sendKeys(getProp("ParkName"));
        getDarienLake().click();

    }

    public AuthWeb() {
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

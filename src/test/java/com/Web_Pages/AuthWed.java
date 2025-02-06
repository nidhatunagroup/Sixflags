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
public class AuthWed extends BaseClassWeb {

    @FindBy(id = "identifierId")
    private WebElement email;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    @FindBy(name = "Passwd")
    private WebElement password;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement showPassword;

    @FindBy(xpath = "//p[normalize-space(text())='Park:']")
    private WebElement parkText;

    @FindBy(xpath = "(//a[@aria-hidden='true'])[1]")
    private WebElement selectParkDarianLake;

    @FindBy(id = "searchPark")
    private WebElement searchPark;

    @FindBy(xpath = "//a[@aria-label='Go to Six Flags Home']//img[1]")
    private WebElement backToHome;

    public void enterUsername(String username) {
        getEmail().sendKeys(username);
    }

    public void enterPassword(String username) {
        getPassword().sendKeys(username);
    }

    public void clickOnNext() {
        clickElement(getNextButton());
    }

    public void navigateToURL(String URL) {
        driver.get().get(URL);
    }

    public void clickShowPassword() {
        getShowPassword().click();
    }

    public AuthWed(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }

    public void authLogin(String email, String password) {
        navigateToURL(getProp("URL"));
        enterUsername(email);
        clickOnNext();
        enterPassword(password);
        clickShowPassword();
        clickOnNext();
        // waitForElement(getParkText());
    }

    public void selectPark() {
        getSearchPark().sendKeys(getProp("ParkName"));
       // actions.sendKeys(getProp("ParkName")).build().perform();
    }
}

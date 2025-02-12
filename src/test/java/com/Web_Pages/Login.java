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
public class Login extends BaseClassWeb {
    @FindBy(xpath = " (//span[contains(text(), 'Login / Sign Up')])[1]")
    private WebElement loginSignupButton;

    @FindBy(xpath = "(//input[@id='email'])[2]")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement submitButton;

    @FindBy(xpath = "//a[normalize-space(text())='Sign Up']")
    private WebElement signupButton;

    public void userLogin(String email, String password) {
        clickElement(getLoginSignupButton());
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        clickElement(getSubmitButton());
    }

    public Login(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

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

    @FindBy(xpath = "//a[normalize-space()='Forgot Password?'][1]")
    private WebElement forgotPassword_bt;

    @FindBy(xpath = "//div[@class='my-9']//input[@id='email']")
    private WebElement addEmailForRecovery;

    @FindBy(xpath = "//button[normalize-space(text())='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//span[normalize-space()='Access Account']")
    private WebElement accessAccount_bt;

    @FindBy(xpath = "//a[@role='menuitem']//p")
    private WebElement accountTag;

    @FindBy(xpath = "//div[@class='mx-auto max-w-content']//a[2]")
    private WebElement manageAccountTab;

    @FindBy(xpath = "//span[normalize-space()='Account Details']")
    private WebElement accountDetailsLink;

    @FindBy(xpath = "//button[normalize-space()='My Profile']")
    private WebElement myProfileTab;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement input_address;


    public void userLogin(String email, String password) {
        clickElement(getLoginSignupButton());
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        clickElement(getSubmitButton());
    }

    public void validate_forgotPassword(String email){
        clickElement(getLoginSignupButton());
        waitFor(5000);
        clickElement(getForgotPassword_bt());
        try{
            if (getSendEmailButton().isDisplayed()) {
                System.out.println("Button is displayed, Issue resolved");
        }
        }catch (NoSuchElementException e) {
            System.out.println("Button is not displayed. Redirecting to forgot password URL.");
            System.out.println(getProp("forgot_URL"));
            driver.get().get(getProp("forgot_URL"));
        }
        getAddEmailForRecovery().sendKeys(email);
        clickElement(getSendEmailButton());
    }

    public void accountInfoCheck() {
        System.out.println("Logged In...");
        clickElement(getAccessAccount_bt());
        clickElement(getAccountTag());
        System.out.println("Account tag clicked...");
        clickElement(getMyProfileTab());
        System.out.println(getMyProfileTab().getText());
        System.out.println("Account details are viewed in Manage account tab.");
    }

    public void editAccountInfo() {
        System.out.println("Logged In...");
        clickElement(getAccessAccount_bt());
        clickElement(getAccountTag());
        System.out.println("Account tag clicked...");
        clickElement(getManageAccountTab());
        System.out.println(getManageAccountTab().getText());
        System.out.println("Switched to manage account tabs, user can edit the fields");
        waitFor(5000);
        webScroll_and_click(getInput_address());
        getInput_address().sendKeys("New city");
    }


    public Login(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

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
public class SignUp extends BaseClassWeb {
    @FindBy(xpath = " (//span[contains(text(), 'Login / Sign Up')])[1]")
    private WebElement login_SignupButton;

    @FindBy(xpath = " (//a[contains(text(), 'Sign Up')]")
    private WebElement New_SignupButton;

    @FindBy(xpath = "(//input[@id='firstName'])")
    private WebElement firstName;

    @FindBy(xpath = "(//input[@id='lastName'])")
    private WebElement lastName;

    @FindBy(xpath = "(//div[@class='mt-4']//input[@id='email'])")
    private WebElement emailId;

    @FindBy(xpath = "(//input[@id='birthdate'])")
    private WebElement dob;

    @FindBy(xpath = "(//input[@id='phoneNumber'])")
    private WebElement mobileNumber;

    @FindBy(xpath = "(//input[@id='password'])")
    private WebElement password;

    @FindBy(xpath = "(//input[@id='retypePassword'])")
    private WebElement retypePassword;

    @FindBy(xpath = "(//input[@type='checkbox'][@name='smsOptIn'])")
    private WebElement sentEmailOption;

    @FindBy(xpath = "(//button[normalize-space()='Sign up'])")
    private WebElement final_Sign_up_button;

    public void new_SignUp(String emailId, String mobileNumber,
                           String password, String retypePassword) {
        clickElement(getLogin_SignupButton());
        waitFor(5000);
        clickElement(getNew_SignupButton());
        getFirstName().sendKeys(getProp("FirstName"));
        getLastName().sendKeys(getProp("LastName"));
        getEmailId().sendKeys(emailId);
        getDob().sendKeys(getProp("Dob"));
        getMobileNumber().sendKeys(mobileNumber);
        getPassword().sendKeys(password);
        getRetypePassword().sendKeys(retypePassword);
        webScroll_and_click(getSentEmailOption());
//        getSentEmailOption().click();
//        webScroll_and_click(getFinal_Sign_up_button());
        clickElement(getFinal_Sign_up_button());

    }


    public SignUp(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

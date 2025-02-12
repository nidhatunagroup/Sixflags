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

    @FindBy(xpath = "(//button[contains(text(), 'Sign up')])")
    private WebElement final_Sign_up_button;

    public void new_SignUp(String firstName, String lastName, String emailId, String dob, String mobileNumber,
                           String password, String retypePassword) {
        clickElement(getLogin_SignupButton());
        clickElement(getNew_SignupButton());
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getEmailId().sendKeys(emailId);
        getDob().sendKeys(dob);
        getMobileNumber().sendKeys(mobileNumber);
        getPassword().sendKeys(password);
        getRetypePassword().sendKeys(retypePassword);
        clickElement(getFinal_Sign_up_button());

    }


    public SignUp(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }

    public void new_SignUp(String firstName) {

}

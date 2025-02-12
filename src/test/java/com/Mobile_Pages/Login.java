
package com.Mobile_Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class Login {

    //Enter email screen
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement email;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    private WebElement submitButton;

    //Email didn't find screen
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign Up\"]")
    private WebElement signUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Continue as Guest\"]")
    private WebElement guest;

    //Signup Screen
    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private WebElement firstName;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    private WebElement lastName;


    @AndroidFindBy(xpath = "(//android.widget.EditText)[4]")
    private WebElement signUpEmail;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[5]")
    private WebElement SignUpPassword;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.CheckBox[1]")
    private WebElement acceptEmailOption;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.CheckBox[2]")
    private WebElement acceptSMSOption;

    public Login(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}


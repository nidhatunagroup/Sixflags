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
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Email Address\"]")
    private WebElement email;

    @AndroidFindBy(xpath = "(//android.view.View)[9]")
    private WebElement submitButton;

    public Login(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}

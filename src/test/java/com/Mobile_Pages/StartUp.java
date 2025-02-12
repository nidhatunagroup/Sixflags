package com.Mobile_Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.Mobile_Utils.BaseClassMobile.isEleDisplayed;
import static com.Mobile_Utils.BaseClassMobile.tapEle;

@Getter
@Setter
public class StartUp {
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    public WebElement allowButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
    private WebElement disAllowButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
    private WebElement whileUsingTheApp;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]")
    private WebElement oneTimeAccess;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement continueButton;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]")
    private WebElement enableDev;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]")
    private WebElement enableProd;

    public void testLaunch() {
        if (isEleDisplayed(getAllowButton())) {
            tapEle(getAllowButton());
            tapEle(getContinueButton());
            tapEle(getContinueButton());
            tapEle(getAllowButton());
            tapEle(getContinueButton());
            tapEle(getContinueButton());
            tapEle(getContinueButton());
            tapEle(getContinueButton());
        }
        System.out.println("App Launched with initial stage");
    }
    public StartUp(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}

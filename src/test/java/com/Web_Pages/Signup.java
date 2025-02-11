package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup extends BaseClassWeb {





    public Signup(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

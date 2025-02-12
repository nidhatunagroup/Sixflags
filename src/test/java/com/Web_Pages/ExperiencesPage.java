package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExperiencesPage extends BaseClassWeb {
    @FindBy(xpath = "//a[@aria-label='Go to Six Flags Home']//img[1]")
    private WebElement backToHome;













    public ExperiencesPage(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}

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
public class HomePage extends BaseClassWeb {

    @FindBy(xpath = "(//span[contains(text(), 'To Plan Your Visit")
    private WebElement planToVisit_Title;


}
package com.Web_Utils;

import com.Web_Pages.*;
import com.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Properties;

public class BaseClassWeb {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Actions actions;
    protected AuthWed authWeb;
    protected Login login;
    protected ExperiencesPage experiencesPage;
    protected RestaurantsPage restaurantsPage;
    protected RidesPage ridesPage;
    protected SwitchTabs switchTabs;
    protected SoftAssert softAssert = new SoftAssert();

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        if (driver.get() == null) {
            driver.set(WebDriverManager.getDriver(browser));
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get().manage().window().maximize();
        }
        if (driver.get() != null) {
        authWeb = new AuthWed(driver.get());
        actions = new Actions(driver.get());
        login = new Login(driver.get());
        experiencesPage = new ExperiencesPage(driver.get());
        restaurantsPage = new RestaurantsPage(driver.get());
        ridesPage = new RidesPage(driver.get());
        switchTabs = new SwitchTabs(driver.get());
        } else {
            throw new RuntimeException("WebDriver initialization failed!");
        }
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }


    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement ele) {
        waitForElement(ele);
        ele.click();
    }

    public static String getProp(String propName) {
        Properties properties = PropertyReader.getProperties();
        return properties.getProperty(propName);
    }

    public static void waitFor(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
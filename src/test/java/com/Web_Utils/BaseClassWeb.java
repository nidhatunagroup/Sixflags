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
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.Properties;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;



public class BaseClassWeb {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected AuthWeb authWeb;
    public Actions actions;
    protected Login login;
    protected ExperiencesPage experiencesPage;
    protected RestaurantsPage restaurantsPage;
    protected RidesPage ridesPage;
    protected SwitchTabs switchTabs;
    protected SignUp signup;
    protected SoftAssert softAssert = new SoftAssert();
    protected JavascriptExecutor js;
    protected HomePage homepage;


    @Parameters("browser")
    @BeforeSuite
    public void setUp(@Optional("chrome") String browser) {
        if (driver.get() == null) {
            driver.set(WebDriverManager.getDriver(browser));
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get().manage().window().maximize();
        }
        if (driver.get() != null) {
            authWeb = new AuthWeb(driver.get());
            switchTabs = new SwitchTabs(driver.get());
            login = new Login(driver.get());
            experiencesPage = new ExperiencesPage(driver.get());
            restaurantsPage = new RestaurantsPage(driver.get());
            ridesPage = new RidesPage(driver.get());
            signup = new SignUp(driver.get());
            js = (JavascriptExecutor) driver.get();
            homepage = new HomePage(driver.get());

        } else {
            throw new RuntimeException("WebDriver initialization failed!");
        }
    }

    @AfterSuite
    public void tearDown() throws IOException {
        if (driver.get() != null) {
            captureScreenshot();
            driver.get().quit();
            driver.remove();  // Remove a driver from thread-local storage
        }
    }


    public void  waitForElement(WebElement element) {
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

    public void webScroll_and_click(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        waitFor(2000);
//        element.click();
    }

    public void captureScreenshot() throws WebDriverException, IOException {
        File screenshot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = STR."screenshots/_\{timestamp}.png";
        FileUtils.copyFile(screenshot, new File(filePath));
        System.out.println(STR."Screenshot saved: \{filePath}");
    }
}
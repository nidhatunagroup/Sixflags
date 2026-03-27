package com.Web_Utils;

import com.Web_Pages.*;
import com.utils.PropertyReader;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Properties;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;



public class BaseClassWeb {
   protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
   protected AuthWeb authWeb;
    public static Actions actions;
    protected Login login;
//    protected ExperiencesPage experiencesPage;
    protected RestaurantsPage restaurantsPage;
    protected RidesPage ridesPage;
    protected SwitchTabs switchTabs;
    protected SignUp signup;
    protected SoftAssert softAssert = new SoftAssert();
    protected HomePage homepage;
    protected PageFooter footer;
    protected PageHeader header;
    protected SeasonPasses seasonPass;
    protected SearchandPromo search;
    protected SelectProperty property;
    protected Calendar calendar;


    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
    public static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            // Add more browsers as needed
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    @Parameters("browser")
    @BeforeClass
//    @BeforeTest
    public void setUp(@Optional("chrome") String browser) {
        WebDriver driverInstance = createDriver(browser); // Factory returns new driver
        setDriver(driverInstance);
        WebDriver driver = getDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();

        authWeb = new AuthWeb(driver);
        switchTabs = new SwitchTabs(driver);
        login = new Login(driver);
//        experiencesPage = new ExperiencesPage(driver);
        restaurantsPage = new RestaurantsPage(driver);
        ridesPage = new RidesPage(driver);
        signup = new SignUp(driver);
        homepage = new HomePage(driver);
        footer = new PageFooter(driver);
        header = new PageHeader(driver);
        seasonPass = new SeasonPasses(driver);
        actions = new Actions(driver);
        search = new SearchandPromo(driver);
        property = new SelectProperty(driver);
        calendar = new Calendar(driver);

        AuthWeb.authLogin();
    }

    @AfterClass
    public void tearDown() {
        if (driver.get() != null) {
            try {
                captureScreenshot();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            driver.get().quit();
            driver.remove();  // Remove a driver from thread-local storage
        waitFor(5000);
        }
    }

    public JavascriptExecutor getJSExecutor() {return (JavascriptExecutor) driver.get();}

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

//        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        if (element != null) {
            waitFor(10000);
            getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
        } else {
            throw new RuntimeException("Element is null, cannot scroll.");
        }
        waitFor(2000);
        System.out.println(element);
        element.click();
    }


    public void scroll_till(WebElement element){
        moveToElement(element);
        element.click();
    }

    public void moveToElement (WebElement element){
        getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
        waitFor(1000);

    }

    public void moveToElementVisible(String locator) {
        WebElement element = getDriver().findElement(By.xpath(locator));
        int scrollCount = 0;
        boolean isVisible = false;
        while (scrollCount < 20) {
            waitFor(1000);
            try {
                if (!(element ==null ) && element.isDisplayed()) {
                    isVisible = true;
                    break;
                }
            }catch (Exception e) {
                System.out.println("Error "+ e);

            }
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            waitFor(500);
            scrollCount++;
        }
        waitFor(500);
    }


    public void captureScreenshot() throws WebDriverException, IOException {
        File screenshot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = STR."screenshots/_\{timestamp}.png";
        FileUtils.copyFile(screenshot, new File(filePath));
        System.out.println(STR."Screenshot saved: \{filePath}");
    }

}
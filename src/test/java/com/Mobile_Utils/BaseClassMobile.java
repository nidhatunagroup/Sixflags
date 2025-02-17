
package com.Mobile_Utils;

import com.Mobile_Pages.Login;
import com.Mobile_Pages.StartUp;
import com.google.common.collect.ImmutableList;
import com.utils.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class BaseClassMobile {
    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    protected Actions actions;
    protected static StartUp startUp;
    protected static Login login;

    @BeforeSuite(alwaysRun = true)
     /*For Parallel Exception
   @BeforeTest(alwaysRun = true)
    @Parameters({"deviceName", "platformVersion"})
    public void setUp(String deviceName, String platformVersion) {
    */
    public void setUp() {
        if (driver.get() == null) {
            try {
                driver.set(new AppiumDriver(MobileDriverManager.getUrl(), MobileDriverManager.getOptions()));
                /*For Parallel Exception
                driver.set(new AndroidDriver(DriverSetup.getUrl(), DriverSetup.getOptions(deviceName,platformVersion)));
                */
                System.out.println("Driver is initialized successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeClass(alwaysRun = true)
    public void initClasses() {
        actions = new Actions(driver.get());
        startUp = new StartUp(driver.get());
        login = new Login(driver.get());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }


    public void tapOnCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tapSequence = new Sequence(finger, 1);
        tapSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapSequence.addAction(new Pause(finger, Duration.ofMillis(100)));
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.get().perform(Collections.singletonList(tapSequence));


    }

    public void waitForVisibilityOfTheElement(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public String getText(WebElement ele) {
        return ele.getText();
    }


    public static void wait(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void touchOn(WebElement ele) {
        waitForVisibilityOfTheElement(ele);
        tapEle(ele);
    }


    public void sentKeys(WebElement ele, String txt) {
        ele.click();
        ele.clear();
        ele.sendKeys(txt);
    }

/*
    public String getAttribute(WebElement ele, String txt) {
        waitForVisibilityOfTheElement(ele);
        return ele.getAttribute(txt);
    }
*/

    public void scroll() {
        Dimension size = driver.get().manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = size.getWidth() / 4;
        int endX = size.getHeight() / 4;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(300)))
                .addAction(
                        finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.get().perform(Collections.singletonList(sequence));
    }

    public void scrollRatio(ScrollDirection dir, double scrollRatio) {
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = driver.get().manage().window().getSize();
        System.out.println(size);
        Point midPoint = new Point((int) (size.width * 0.4), (int) (size.height * 0.5));
        int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
        int top = midPoint.y - (int) (midPoint.y * scrollRatio);
        //  Point Start = new Point(midPoint.x, bottom);
        //   Point End = new Point(midPoint.x, top);
        int left = midPoint.x - (int) (midPoint.x * scrollRatio);
        int right = midPoint.x + (int) (midPoint.x * scrollRatio);
        if (dir == ScrollDirection.UP) {
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), Duration.ofMillis(500));
        } else if (dir == ScrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), Duration.ofMillis(500));
        } else if (dir == ScrollDirection.LEFT) {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), Duration.ofMillis(500));
        } else if (dir == ScrollDirection.RIGHT) {
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), Duration.ofMillis(500));
        }
    }

    protected void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.get().perform(ImmutableList.of(swipe));
    }

    public static void tapEle(WebElement ele) {
        Point location = ele.getLocation();
        Dimension size = ele.getSize();
        Point centerOfEle = getCenter(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence seq = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfEle))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(150)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.get().perform(Collections.singletonList(seq));
    }

    private static Point getCenter(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

    private static Point getCenter(WebElement el) {
        Point location = el.getLocation();
        Dimension size = el.getSize();
        return new Point(location.x + size.getWidth() / 2, location.y + size.getHeight() / 2);
    }

    public void scrollToTop() {
        String prevPageSource = "";
        while (isEndOfPage(prevPageSource)) {
            prevPageSource = driver.get().getPageSource();
            scrollRatio(ScrollDirection.DOWN, 0.4);
            wait(200);
        }
    }

    public boolean isEndOfPage(String pageSource) {
        return !pageSource.equals(driver.get().getPageSource());
    }


    public void hideKeyBoard() {
        driver.get().navigate().back();
    }


    public String getProp(String propName) {
        Properties properties = PropertyReader.getProperties();
        return properties.getProperty(propName);
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void attachScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot();
        }
    }

    public void scrollTillVisibleAndClick(WebElement element) {
        while (true) {
            try {
                if (element.isDisplayed()) {
                    tapEle(element);
                    break;
                }
            } catch (NoSuchElementException e) {
                scrollRatio(ScrollDirection.DOWN, 0.3);
            }
        }
    }

    /*    public void scrollTillVisibleAndClick(WebElement element) {
            String prevPageSource = "";
            while (true) {
                try {
                    if (element.isDisplayed()) {
                        tapEle(element);
                        break;
                    }
                } catch (NoSuchElementException e) {
                    String currentPageSource = driver.get().getPageSource();
                    if (currentPageSource.equals(prevPageSource)) {
                        System.out.println("Reached the bottom of the page, element not found.");
                        break;
                    }
                    prevPageSource = currentPageSource;
                    scrollRatio(ScrollDirection.DOWN, 0.3);
                }
            }
        }*/
    public void scrollToBottom() {
        String prevPageSource = "";
        while (isEndOfPage(prevPageSource)) {
            prevPageSource = driver.get().getPageSource();
            scrollRatio(ScrollDirection.DOWN, 0.4);
        }
    }

    public void scrollToLeftEnd() {
        String prevPageSource = "";
        while (isEndOfPage(prevPageSource)) {
            prevPageSource = driver.get().getPageSource();
            scrollRatio(ScrollDirection.LEFT, 0.4);
        }
    }

    public boolean isEndOfThePage() {
        String prevPageSource = driver.get().getPageSource();
        scrollRatio(ScrollDirection.DOWN, 0.75);
        String currentPageSource = driver.get().getPageSource();
        return prevPageSource.equals(currentPageSource);
    }


    public boolean isElementClickable(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }

    public void list(List<WebElement> ele, int index) {
        ele.get(index).click();
    }

    public boolean isClickable(WebElement ele) {
        return ele.isEnabled();
    }

    public static boolean isEleDisplayed(WebElement ele) {
        return ele.isDisplayed();
    }

    public void getCount() {
////android.widget.TextView[contains(@text, 'All (' )]

    }
}

/*
 * public static String dateTine() {
 * DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
 * Date date = new Date();
 * System.out.println(dateFormat.format(date));
 * return dateFormat.format(date);
 * }
 *
 * @BeforeMethod public void startScreenRecording() {
 * startRecording();
 * }
 * @AfterMethod public void stopScreenRecording(ITestResult result) {
 * stopRecording();
 * }
 * <p>
 * public void startRecording() {
 * if (driver.get() instanceof AndroidDriver) {
 * ((AndroidDriver) driver.get()).startRecordingScreen();
 * } else {
 * throw new UnsupportedOperationException("Screen recording not supported for this driver");
 * }
 * }
 * @Attachment(value = "Screen Recording", type = "video/mp4")
 * public void stopRecording() {
 * String video = "";
 * if (driver.get() instanceof AndroidDriver) {
 * video = ((AndroidDriver) driver.get()).stopRecordingScreen();
 * } else {
 * throw new UnsupportedOperationException("Screen recording not supported for this driver");
 * }
 * Base64.getDecoder().decode(video);
 * }
 * <p>
 * public void dragNDrop(WebElement source, WebElement target) {
 * Point pSource = getCenter(source);
 * Point pTarget = getCenter(target);
 * swipe(pSource, pTarget, Duration.ofMillis(500));
 * }
 * <p>
 * public void scrollUntilElementVisible(WebElement element, int maxScrolls) {
 * int scrollCount = 0;
 * boolean isVisible = false;
 * while (!isVisible && scrollCount < maxScrolls) {
 * try {
 * isVisible = true;
 * } catch (Exception e) {
 * scrollRatio(ScrollDirection.DOWN, 0.5);
 * scrollCount++;
 * }
 * }
 * }
 * <p>
 * public void ScrollToClick(WebElement element) {
 * String prevPageSource = "";
 * while (isEndOfPage(prevPageSource)) {
 * prevPageSource = driver.get().getPageSource();
 * <p>
 * if (element.isDisplayed()) {
 * break;
 * }
 * scrollRatio(ScrollDirection.DOWN, 0.4);
 * <p>
 * }
 * }
 */

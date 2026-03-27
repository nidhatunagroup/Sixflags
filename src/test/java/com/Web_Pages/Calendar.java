package com.Web_Pages;

import com.Web_Utils.BaseClassWeb;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

@Getter
@Setter
public class Calendar extends BaseClassWeb {

    // --- WebElements for Calendar Navigation ---
    @FindBy(xpath = "//button[@aria-label='Next Month']")
    private WebElement nextMonthArrow;

    @FindBy(xpath = "//button[@aria-label='Previous Month']")
    private WebElement previousMonthArrow;

    // Header displaying the current Month Year (e.g., "October 2025")
    @FindBy(xpath = "//button[@class='react-calendar__navigation__label']//span")
    private WebElement calendarHeader;

    @FindBy(xpath = "//div[@class='react-calendar__year-view']//button")
    private WebElement listOfMonths;

    // The rest of your WebElements
    @FindBy(xpath = "//div[@class='flex items-center']//span[contains(text(),'Calendar')]")
    private WebElement calendarButton;

    @FindBy(xpath = "//a[@aria-label='Go to Cedar Point Home']")
    private WebElement homePageLogo;

    @FindBy(xpath = "//h2//span[contains(text(),'Hours For')]")
    private WebElement calendarVerification;


    private String getCurrentMonth(String headerText) {
        // Example: "October 2025" -> "October"
        String[] parts = headerText.trim().split(" ");
        return parts.length > 0 ? parts[0] : "";
    }

    private int getCurrentYear(String headerText) {
        // Example: "October 2025" -> 2025
        String[] parts = headerText.trim().split(" ");
        if (parts.length >= 2) {
            try {
                // Ensure only digits are parsed
                return Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
            } catch (NumberFormatException e) {
                System.out.println("Year part is not a number: " + parts[1]);
            }
        }
        return -1;
    }

    private int getMonthIndex(String monthName) {
        // Returns 1 for January, 12 for December, -1 if not found
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(monthName)) {
                return i + 1;
            }
        }
        return -1;
    }

    // --- Main Action Method ---

    public void selectSpecificDate(String day, String month, String year) {
        // Get the WebDriver instance
        WebDriver currentDriver = driver.get();

        // 1. Force Calendar into Year Selection View (where header shows the year)
        // The React Calendar header often needs clicks to change the view level:
        // Day View (e.g., "October 2025") -> Month View (e.g., "2025") -> Year View (e.g., "2020 - 2029")
        // We assume two clicks are needed to reliably show the Year.
        getCalendarHeader().click();
//        getCalendarHeader().click();
        System.out.println("Forced calendar into Year Selection View.");

        // Get the initial header text, which should now contain the year or year range
        // Example: "2025" or "2020 - 2029"
        String displayedHeader = getCalendarHeader().getText().trim();
        System.out.println("Starting Year Header: " + displayedHeader);

        // 2. Loop until the required YEAR is displayed
        // We must rely on parsing the year from the header, even if it's a range.
        while (!displayedHeader.contains(year)) {

            // Assuming a helper method to get the *first* year from a range header (e.g., "2020 - 2029" -> 2020)
            // Since we don't have a specific helper, we'll try to get the year closest to the start.
            int currentYearDisplayed = getCurrentYear(displayedHeader);

            // This navigation is for the Year View (not month by month)
            boolean isFutureYear = Integer.parseInt(year) > currentYearDisplayed;

            if (isFutureYear) {
                // Click next arrow to move to the next year/year range
                getNextMonthArrow().click(); // Assuming the same arrow is reused for year navigation
                System.out.println("Navigating forward to year " + year);
            } else {
                // Click previous arrow to move to the previous year/year range
                getPreviousMonthArrow().click(); // Assuming the same arrow is reused for year navigation
                System.out.println("Navigating backward to year " + year);
            }

            // Wait for UI to update after navigation
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Navigation wait interrupted.");
            }

            // Update current displayed year/year-range
            displayedHeader = getCalendarHeader().getText().trim();
        }

        System.out.println("Successfully navigated to target year/range: " + displayedHeader);

        // 3. Select the required month from the month-list/grid
        // At this point, the month list should be visible.
        String monthXpath = String.format("//div[@class='react-calendar__year-view']//button[contains(normalize-space(),'%s')]", month);

        try {
            // Find the specific month element using the dynamic XPath
            WebElement monthElement = currentDriver.findElement(By.xpath(monthXpath));
            monthElement.click();
            System.out.println("Selected month: " + month);

            // Wait for UI to transition back to day view after month click
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // 4. Select the day if it's enabled
            // Xpath to find the day button.
            String dayXpath = String.format("//div[@class='react-calendar__month-view__days']//button[normalize-space()='%s']", day);

            WebElement dateElement = currentDriver.findElement(By.xpath(dayXpath));

            // *** The requested if condition logic: Check if the date is enabled ***
            if (dateElement.isEnabled()) {
                dateElement.click();
                System.out.println("Successfully selected date: " + day + " " + month + " " + year);
            } else {
                System.out.println("Date " + day + " " + month + " " + year + " is present but disabled/not selectable.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Could not find the month '" + month + "' or day '" + day + "' in the calendar view.");
            e.printStackTrace();
        }
    }

    public void datePicker(){
        clickElement(getCalendarButton());
        waitFor(5000); // Consider using explicit waits instead of Thread.sleep()
//        clickElement(getCalendarHeader());
//        waitFor(2000);
        selectSpecificDate("09", "October", "2025");
        waitFor(10000);
        // Assuming getCalendarVerification() uses the @FindBy for element visibility
        if (getCalendarVerification() != null) {
            softAssert.assertTrue(getCalendarVerification().isDisplayed(), "Calendar verification element is displayed.");
        } else {
            System.out.println("Calendar verification element not found.");
        }
        waitFor(2000);
        clickElement(getHomePageLogo());
        waitFor(3000);
    }

    public Calendar(WebDriver webDriver) {
        PageFactory.initElements(driver.get(), this);
    }
}
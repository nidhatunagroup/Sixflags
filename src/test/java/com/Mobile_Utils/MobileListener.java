package com.Mobile_Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MobileListener extends BaseClassMobile implements ITestListener {
    String videoData;

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        captureScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result);
    }


    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(AppiumDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public MobileListener(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void captureScreenshot(ITestResult result) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

            File destFile = new File("allure-results/Screenshots/" + result.getName() + ".png");
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Allure.addAttachment("Screenshot - " + result.getName() + dateTime(), "image/png", new FileInputStream(destFile), ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
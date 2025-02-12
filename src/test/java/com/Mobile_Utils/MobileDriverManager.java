package com.Mobile_Utils;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.URL;
import java.time.Duration;
public class MobileDriverManager {
    public static synchronized URL getUrl() {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
        service.start();
        return service.getUrl();
    }

    // public static synchronized UiAutomator2Options getOptions(String deviceName, String platformVersion) {
    public static synchronized UiAutomator2Options getOptions() {
        return new UiAutomator2Options()
                .setPlatformName("Android")
                /*.setDeviceName(deviceName)
                .setPlatformVersion(platformVersion)*/
                .setDeviceName("emulator-5554")
                .setPlatformVersion("12")
                .setNoReset(false)
                .setAppPackage("com.sixflags.test.android.debug")
                .setAppActivity("com.sixflags.android.MainActivity")
                .setAppWaitDuration(Duration.ofSeconds(30))
                .setEnsureWebviewsHavePages(true)
                .setAutomationName("UiAutomator2")
                .setNewCommandTimeout(Duration.ofSeconds(20))
                .setAutoGrantPermissions(true);

    }
}

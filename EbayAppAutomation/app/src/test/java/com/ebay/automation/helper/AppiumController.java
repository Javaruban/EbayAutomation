package com.ebay.automation.helper;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * Created by Ruban on 15/02/18.
 */

public class AppiumController {

    private static final String APPIUM_VERSION = "1.3.2";
    private static final String PLATFORM_NAME = "android";
    private static final String DEVICE_NAME = "Pixel_4548";
    private static final String APP_VERSION= "8.1.0";
    private static final String APP_PACKAGE = "com.ebay.mobile";
    private static final String APP_ACTIVITY = "com.ebay.mobile.activities.MainActivity";

    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID
    }

    public static AppiumController instance = new AppiumController();
    public AndroidDriver<?> driver;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        switch (executionOS) {
            case ANDROID:


                AppiumServiceBuilder builder = new AppiumServiceBuilder()
                        .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                        .usingAnyFreePort();

                appiumService = builder.build();
                appiumService.start();
                appiumServiceUrl = appiumService.getUrl().toString();
                System.out.println("Appium Service Address : - "+ appiumServiceUrl);

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium-version", APPIUM_VERSION);
                capabilities.setCapability("platformName", PLATFORM_NAME);
                capabilities.setCapability("deviceName", DEVICE_NAME);
                capabilities.setCapability(CapabilityType.VERSION, APP_VERSION);
                capabilities.setCapability("appPackage", APP_PACKAGE);
                capabilities.setCapability("appActivity", APP_ACTIVITY);

                driver = new AndroidDriver(new URL(appiumServiceUrl), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        appiumService.stop();
    }
}
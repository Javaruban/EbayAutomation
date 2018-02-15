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
                capabilities.setCapability("appium-version", "1.3.2");
                capabilities.setCapability("platformName", "android");
                capabilities.setCapability("deviceName", "Pixel_4548");
                capabilities.setCapability(CapabilityType.VERSION, "8.1.0");
                capabilities.setCapability("appPackage", "com.ebay.mobile");
                capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");

                driver = new AndroidDriver(new URL(appiumServiceUrl), capabilities);//if called via desktop appium http://127.0.0.1:4723/wd/hub
                //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
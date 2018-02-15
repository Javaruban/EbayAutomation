package com.ebay.automation;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumTest {

    private AndroidDriver driver;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;

    @Before
    public void setUp() throws MalformedURLException {
/*        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "Pixel_4548");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "8.1.0");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.ebay.mobile");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                //.withArgument(GeneralServerFlag.APP, System.getProperty("user.dir") + "/build/wordpress.apk")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                //.withLogFile(new File(System.getProperty("user.dir") + "/target/logs/sample.txt"))
                .usingAnyFreePort()
                /* and so on */;


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

        // Set job name
        //capabilities.setCapability("name", "Appium Sample" + date);
        //String appPath = System.getenv("android_app_path");
        //assert appPath != null: "Path to Android app is not set";
        //System.out.println("Android App path: "+ appPath);
        //capabilities.setCapability("app", appPath);
        driver = new AndroidDriver(new URL(appiumServiceUrl), capabilities);//if called via desktop appium http://127.0.0.1:4723/wd/hub

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Helpers.init(driver);


    }

    @Test
    public void scrollToBottom(){

        scrollTo("Handpicked by eBay");

    }

    @Test
    public void scrollToBottom1(){

        scrollTo("Find Your Sound");

    }

/*    @Test
    public void clickRegister() {

       // Click on DELETE/CLR button to clear result text box before running test.
        //driver.findElements(By.xpath("//android.widget.Button")).get(0).click();

        // Click on number 2 button.
       // driver.findElement(By.name("7")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        findElementByName("REGISTER").click();
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //scrollTo("Handpicked by eBay");
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }*/

    private MobileElement findElementByName(String elementName){
       return (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='"+elementName+"']"));

    }


    private boolean isElementPresent(String elementName){


        return  driver.findElement(By.xpath("//android.widget.Button[@text='"+elementName+"']")).isDisplayed();

    }



    public MobileElement scrollTo(String text){
        return (MobileElement) driver.findElement(MobileBy.
                AndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".scrollable(true)).scrollIntoView(resourceId(\"android:id/list\")).scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"))"));
    }


    //@AfterMethod
    public void afterMethod()
    {
        //driver.closeApp();
        //driver.launchApp();
    }


    @After
    public void End() throws Exception {
        System.out.println("Stop driver");
        driver.quit();
        System.out.println("Stop appium service");
        appiumService.stop();
    }

    private void findElementByName(){

        //MobileElement webElement = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='REGISTER']"));
        // webElement.click();
        Assert.assertTrue("Targeted element App is not present on screen", isElementPresent("REGISTER"));
        // driver.findElement(s)(By.className('android.widget.EditText'));
        // driver.findElement(s)(By.name('Buy 101 devices'));
        // driver.findElement(s)(By.id('com.bitbar.testdroid:id/radio0'));
        // elem = driver.find_element_by_xpath('//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]')



        /* Any android.widget.RadioButton with text value 'Use Testdroid Cloud' */
        //driver.findElement(By.xpath("//android.widget.RadioButton[@text='Use Testdroid Cloud']"));

        /* Any android.widget.EditText with resource-id value 'com.bitbar.testdroid:id/editText1' */
        // driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.bitbar.testdroid:id/editText1']"));

        /* Button index 1, with parent LinearLayout index 2, with parent LinearLayout index 1, with parent ScrollView index 1. */
        // driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[1]"));

    }
}

package com.ebay.automation.pages;

import com.ebay.automation.helper.AppiumHelper;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by Ruban on 15/02/18.
 */

public class HomePage extends AppiumHelper implements HomePageListener {

    @FindBy(xpath = "//android.widget.Button[@text='RELOAD']")
    public MobileElement reloadButton;


    @FindBy(xpath = "//*[@text='Register']")
    public MobileElement registerButton;

    @FindBy(xpath = "//*[@text='SELLING']")
    public MobileElement sellingButton;

    public HomePage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Override
    public boolean isHomePageLoaded() {
        return isVisible(registerButton);
    }

    @Override
    public void clickElement() {

        clickElement(reloadButton);


    }
}

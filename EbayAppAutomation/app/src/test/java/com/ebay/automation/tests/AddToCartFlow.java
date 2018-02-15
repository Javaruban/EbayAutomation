package com.ebay.automation.tests;

import com.ebay.automation.helper.AppiumController;
import com.ebay.automation.pages.HomePage;

import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.util.EmptyStackException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by Ruban on 15/02/18.
 */

public class AddToCartFlow extends BaseTestClass {

    @Test
    public void AddToCartFlow() {

        loginPage.clickElement();
        if(loginPage.isHomePageLoaded()){

        }else{
            throw new EmptyStackException();
        }

    }



}

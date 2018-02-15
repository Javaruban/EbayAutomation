package com.ebay.automation.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;

/**
 * Created by Ruban on 15/02/18.
 */

public class AppiumHelper extends AppiumController{

    //wait for maximum 30 seconds before any operation
    WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);

    protected void clickElement(MobileElement mobileElement) {
        mobileElement = waitTillElementVisible(mobileElement);
        mobileElement.click();
    }


    protected boolean isVisible(MobileElement mobileElement) {

        boolean status = false;
        try {
            mobileElement = waitTillElementVisible(mobileElement);
            status = true;
        } catch (Exception e) {

        }
        return status;
    }

    private MobileElement waitTillElementVisible(MobileElement mobileElement) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOf(mobileElement));

    }
}

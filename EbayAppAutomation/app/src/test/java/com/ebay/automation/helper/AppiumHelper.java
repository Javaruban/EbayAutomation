package com.ebay.automation.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

/**
 * Created by Ruban on 15/02/18.
 */

public class AppiumHelper extends AppiumController{


    //wait for maximum 30 seconds before any operation
    WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);

    protected void clickElement(MobileElement mobileElement) {
        //mobileElement = waitTillElementVisible(mobileElement);
        mobileElement.click();
        //WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);
    }


    protected boolean isElementVisibleWaitAndCheck(MobileElement mobileElement) {

        boolean status = false;
        try {
            waitTillElementVisible(mobileElement);
            status = true;
        } catch (Exception e) {
            throw(e);

        }
        return status;
    }

    protected boolean isElementPresent(MobileElement mobileElement){


        return  mobileElement.isDisplayed();

    }

    protected void checkElementVisibility(MobileElement mobileElement){


        if(!isElementPresent(mobileElement)){
            throw new ElementNotVisibleException(mobileElement.getId()+" Not Present");
        }

    }

    private MobileElement waitTillElementVisible(MobileElement mobileElement) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOf(mobileElement));

    }

    /**
     /* Method to swipe screen from Bottom to Top (Vertical) Get the size of
     * screen. Find swipe start and end point from screen's width and height.
     * Find starty point which is at bottom side of screen. Find endy point
     * which is at top side of screen. Find horizontal point where you wants to
     * swipe. It is in middle of screen width.
     * Time duration should be in milliseconds
     */

    protected void bottomTopSwipe(int timeInSec) {


        Dimension size = AppiumController.instance.driver.manage().window().getSize();
        System.out.println(size);
        int starty = (int) (size.height * 0.50);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        System.out.println("Start swipe operation");
        AppiumController.instance.driver.swipe(startx, starty, startx, endy, timeInSec * 1000);
        WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);

    }

    /**
     *
     * Method to swipe screen from Top to Bottom (Vertical) Get the size of
     * screen. Find swipe start and end point from screen's width and height.
     * Find starty point which is at bottom side of screen. Find endy point
     * which is at top side of screen. Find horizontal point where you wants to
     * swipe. It is in middle of screen width.
     * Time duration should be in milliseconds
     */

    protected void topBottomSwipe(int timeInSec) {

        // mobileElement.swipe(SwipeElementDirection.DOWN, timeInSec * 1000);

        Dimension size = AppiumController.instance.driver.manage().window().getSize();
        System.out.println(size);
        int starty = (int) (size.height * 0.50);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        System.out.println("Start swipe operation");
        AppiumController.instance.driver.swipe(startx, endy, startx, starty, timeInSec * 1000);
        WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);

    }

    /**
     *
     * Method to swipe screen from right to left (Horizontal) duration should be
     * in milliseconds Get the size of screen. Find swipe start and end point
     * from screen's width and height. Find startx point which is at right side
     * of screen. Find endx point which is at left side of screen. Find vertical
     * point where you wants to swipe. It is in middle of screen height.
     * Time duration should be in milliseconds
     */

    protected void rightLeftSwipe(int timeInSec) {

        Dimension size = AppiumController.instance.driver.manage().window().getSize();
        System.out.println(size);
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        System.out.println("Start swipe operation");
        AppiumController.instance.driver.swipe(startx, starty, endx, starty, timeInSec * 1000);
        WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);

    }

    /**
     *
     * Method to swipe screen from left to right (Horizontal) duration should be
     * in milliseconds Get the size of screen. Find swipe start and end point
     * from screen's width and height. Find startx point which is at right side
     * of screen. Find endx point which is at left side of screen. Find vertical
     * point where you wants to swipe. It is in middle of screen height.
     * Time duration should be in milliseconds
     */

    protected void leftRightSwipe(int timeInSec) {
        // duration should be in milliseconds
        Dimension size = AppiumController.instance.driver.manage().window().getSize();
        System.out.println(size);
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        System.out.println("Start swipe operation");
        AppiumController.instance.driver.swipe(endx, starty, startx, starty, timeInSec * 1000);
        WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);

    }


    /**
     * This method only work for this page and assumes the app supports keyboard hide on click-away.
     */
    public void hideKeyboard(MobileElement mobileElement) {
        mobileElement.click();
    }


    public void typeText(MobileElement mobileElement, String enterString){

        mobileElement.clear();
        mobileElement.sendKeys(enterString);
    }

}
